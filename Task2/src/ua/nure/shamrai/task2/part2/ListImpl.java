package ua.nure.shamrai.task2.part2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl<E> implements List<E> {
	private Node<E> firstHead;
	private Node<E> lastTail;
	private int sizeof;

	static class Node<E> {
		private E elementNode;
		private Node<E> next;

		Node(E element, Node<E> next) {
			elementNode = element;
			this.next = next;
		}

	}

	class IteratorImpl implements Iterator<E> {
		private Node<E> position;
		private Node<E> previous;

		@Override
		public boolean hasNext() {
			if (position == null) {
				return firstHead != null;
			} else {
				return position.next != null;
			}
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			previous = position;

			if (position == null) {
				position = firstHead;
			} else {
				position = position.next;
			}

			return position.elementNode;
		}

		@Override
		public void remove() {
			if (previous == position) {
				throw new IllegalStateException();
			}
			if (position == firstHead) {
				removeFirst();
			} else if (position == lastTail) {
				removeLast();
			} else {
				previous.next = position.next;
				sizeof--;
			}
			position = previous;
		}

	}

	@Override
	public String toString() {
		if (sizeof == 0) {
			return "[]";
		}
		Node<E> currentNode = firstHead;
		StringBuilder strb = new StringBuilder();
		strb.append('[');
		while (true) {
			strb.append(currentNode.elementNode);
			if (currentNode.equals(lastTail)) {
				return strb.append(']').toString();
			}
			currentNode = currentNode.next;
			strb.append(", ");
		}
	}

	@Override
	public void clear() {
		firstHead = lastTail = null;
		sizeof = 0;

	}

	@Override
	public int size() {
		return sizeof;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImpl();
	}

	@Override
	public void addFirst(E element) {
		Node<E> newNode;
		if (firstHead == null) {
			newNode = new Node<>(element, null);
			firstHead = lastTail = newNode;
		} else {
			newNode = new Node<>(element, firstHead);
			firstHead = newNode;
		}
		sizeof++;
	}

	@Override
	public void addLast(E element) {
		Node<E> newNode;
		if (lastTail == null) {
			newNode = new Node<>(element, null);
			firstHead = lastTail = newNode;
		} else {
			newNode = new Node<>(element, null);
			lastTail.next = newNode;
			lastTail = newNode;
		}
		sizeof++;

	}

	@Override
	public void removeFirst() {
		firstHead = firstHead.next;
		sizeof--;
	}

	@Override
	public void removeLast() {
		Node<E> currentNode = firstHead;
		for (int j = 0; j < sizeof - 1; j++) {
			if (currentNode.next == lastTail) {
				lastTail = currentNode;
				sizeof--;
			}
			currentNode = currentNode.next;
		}
	}

	@Override
	public E getFirst() {
		E element = firstHead.elementNode;
		removeFirst();
		return element;
	}

	@Override
	public E getLast() {
		E element = lastTail.elementNode;
		removeLast();
		return element;
	}

	@Override
	public E search(E element) {
		Node<E> currentNode = firstHead;
		for (int i = 0; i < sizeof; i++) {
			E currentElement = currentNode.elementNode;
			if (currentElement.equals(element)) {
				return currentElement;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public boolean remove(E element) {
		Node<E> currentNode = firstHead;
		Node<E> previous = null;
		while (currentNode != null) {
			if (currentNode.elementNode.equals(element)) {
				if (currentNode == firstHead) {
					removeFirst();
				} else if (currentNode == lastTail) {
					removeLast();
				} else {
					sizeof--;
					previous.next = currentNode.next;

				}
				return true;
			}
			previous = currentNode;
			currentNode = currentNode.next;
		}
		return false;
	}

}