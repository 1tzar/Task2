package ua.nure.shamrai.task2.part3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl<E> implements Queue<E> {

	private Object[] array;
	private int i;

	QueueImpl() {
		array = new Object[0];
	}

	class IteratorImpl implements Iterator<E> {
		private int iteratorIndex;
		private int lastIndex;

		IteratorImpl() {
			iteratorIndex = lastIndex = -1;
		}

		@Override
		public boolean hasNext() {
			return iteratorIndex < i - 1;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (iteratorIndex < i - 1) {
				lastIndex = iteratorIndex;
				return (E) array[++iteratorIndex];
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			if (lastIndex != iteratorIndex) {
				Object[] tmp = array;
				int k = 0;
				array = new Object[i - 1];
				for (int j = 0; j < i; j++) {
					if (j == iteratorIndex) {
						continue;
					}
					array[k++] = tmp[j];
				}
				i--;
				iteratorIndex--;
				lastIndex = iteratorIndex;

			} else {
				throw new IllegalStateException();
			}
		}

	}

	@Override
	public void clear() {
		array = new Object[0];
		i = 0;
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImpl();
	}

	@Override
	public void enqueue(E element) {
		if (i == 0) {
			array = new Object[i + 1];
			array[i++] = element;

		} else {
			Object[] tmparray = array;
			array = new Object[i + 1];
			System.arraycopy(tmparray, 0, array, 0, tmparray.length);
			array[i++] = element;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E top() {
		if (array.length > 0) {
			return (E) array[0];
		} else {
			throw new NoSuchElementException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E dequeue() {
		if (i == 0) {
			throw new NoSuchElementException();
		} else {
			Object n = array[0];
			Object[] tmp = new Object[i - 1];
			for (int j = 0, k = 1; k < i; j++, k++) {
				tmp[j] = array[k];
			}
			array = tmp;
			i--;
			return (E) n;
		}
	}

	public String toString() {
		if (i == 0) {
			return "[]";
		}

		StringBuilder str = new StringBuilder();
		str.append('[');
		for (int j = 0;; j++) {
			str.append(String.valueOf(array[j]));
			if (j == array.length - 1) {
				return str.append(']').toString();
			}
			str.append(", ");
		}
	}
}