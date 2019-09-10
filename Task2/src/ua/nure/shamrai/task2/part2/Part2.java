package ua.nure.shamrai.task2.part2;

import java.util.Iterator;

public class Part2 {

	public static void main(String[] args) {
		List<Integer> myList = new ListImpl<>();
		myList.addLast(1);
		myList.addLast(2);
		myList.addLast(3);

		Iterator<Integer> it = myList.iterator();
		System.out.println(it.next());
		it.remove();
	
		
	}
}
