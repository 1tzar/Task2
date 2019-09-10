package ua.nure.shamrai.task2.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl<E> implements Stack<E> {
	private Object[] stack;
	private int i;

	@Override
	public void clear() {
		stack = new Object[0];
		i = 0;
	}

	@Override
	public int size() {
		return stack.length;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImpl();
	}

	@Override
	public void push(E element) {

		if (i == 0) {
			stack = new Object[i + 1];
			stack[i++] = element;

		} else {
			Object[] tmpStack = stack;
			stack = new Object[i + 1];
			System.arraycopy(tmpStack, 0, stack, 0, tmpStack.length);
			stack[i++] = element;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		if (i == 0) {
			throw new NoSuchElementException();
		}
		Object element = stack[i - 1];
		Object[] tmpStack = stack;
		stack = new Object[i - 1];
		for (int j = 0; j < i - 1; j++) {
			stack[j] = tmpStack[j];
		}
		i--;
		return (E) element;

	}

	@SuppressWarnings("unchecked")
	@Override
	public E top() {
		if (i == 0) {
			throw new NoSuchElementException();
		}
		return (E) stack[i - 1];
	}

	@Override
	public String toString() {
		if (i == 0) {
			return "[]";
		}
		StringBuilder strb = new StringBuilder();
		strb.append("[");
		for (int j = 0;; j++) {
			strb.append(stack[j]);
			if (j == i - 1) {
				return strb.append(']').toString();
			}
			strb.append(", ");
		}
	}

	class IteratorImpl implements Iterator<E> {
		private int currentIndex;
		private int lastRemovedIndex;

		IteratorImpl() {
			currentIndex = lastRemovedIndex = i;
		}

		@Override
		public boolean hasNext() {
			return currentIndex > 0;

		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (currentIndex > 0) {
				return (E) stack[--currentIndex];
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			if (lastRemovedIndex == currentIndex) {
				throw new IllegalStateException();
			}
			Object[] tmpStack = stack;
			int k = 0;
			stack = new Object[--i];
			for (int j = 0; j < tmpStack.length; j++) {
				if (j != currentIndex) {
					stack[k++] = tmpStack[j];
				} else {
					lastRemovedIndex = currentIndex;
				}
			}
		}

	}

}