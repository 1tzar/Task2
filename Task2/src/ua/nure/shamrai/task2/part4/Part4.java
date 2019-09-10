package ua.nure.shamrai.task2.part4;

import java.util.Iterator;

public class Part4 {

	public static void main(String[] args) {
		Stack<String> stack = new StackImpl<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		Iterator<String> it = stack.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		stack.clear();
		System.out.println(stack);
		
		
	}

}
