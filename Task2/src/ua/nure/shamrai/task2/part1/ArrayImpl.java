package ua.nure.shamrai.task2.part1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl<E> implements Array<E> {

	private Object[] arrayList;
	private int i;
	private int size;

	@Override
	public void clear() {
		arrayList = new Object[0];
		size = 0;
		i = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImpl();
	}

	@Override
	public void add(E element) {
		if (size == 0) {
			arrayList = new Object[size + 1];
		} else {
			Object[] tmpArray = arrayList;
			arrayList = new Object[size + 1];
			System.arraycopy(tmpArray, 0, arrayList, 0, tmpArray.length);
		}
		arrayList[i++] = element;
		size++;
	}

	@Override
	public void set(int index, E element) {
		arrayList[index] = element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		return (E) arrayList[index];
	}

	@Override
	public int indexOf(E element) {
		for (int j = 0; j < size; j++) {
			if (element.equals(arrayList[j])) {
				return j;
			}
		}
		return -1;
	}

	@Override
	public void remove(int index) {
		Object[] tmp = new Object[size - 1];
		int k = 0;
		for (int j = 0; j < size; j++) {
			if (j == index) {
				continue;
			}
			tmp[k++] = arrayList[j];
		}
		arrayList = tmp;
		size--;

	}

	class IteratorImpl implements Iterator<E> {
		private int iteratorIndex;
		private int lastIndex;

		IteratorImpl() {
			iteratorIndex = lastIndex = -1;
		}

		@Override
		public boolean hasNext() {
			return iteratorIndex < size - 1;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (iteratorIndex < size - 1) {
				lastIndex = iteratorIndex;
				return (E) arrayList[++iteratorIndex];
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			if (lastIndex != iteratorIndex) {
				Object[] tmp = arrayList;
				int k = 0;
				arrayList = new Object[size - 1];
				for (int j = 0; j < size; j++) {
					if (j == iteratorIndex) {
						continue;
					}
					arrayList[k++] = tmp[j];
				}
				size--;
				iteratorIndex--;
				lastIndex = iteratorIndex;

			} else {
				throw new IllegalStateException();
			}
		}

	}

	@Override
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder strb = new StringBuilder();
		strb.append('[');
		for (int j = 0;; j++) {
			strb.append(arrayList[j]);
			if (j == size - 1) {
				return strb.append(']').toString();
			}
			strb.append(", ");
		}
	}

}
