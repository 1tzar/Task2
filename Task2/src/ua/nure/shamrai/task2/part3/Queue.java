package ua.nure.shamrai.task2.part3;

import ua.nure.shamrai.task2.Container;

public interface Queue<E> extends Container<E> {
	void enqueue(E element);

	E dequeue();

	E top();
}
