package ua.nure.shamrai.task2.part1;

import java.util.Iterator;

public class Part1 {

	public static void main(String[] args) {
		ArrayImpl<String> array = new ArrayImpl<>();
        System.out.println("Add a b c d e f");
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");
        array.add("e");
        array.add("f");
        System.out.println(array.toString());




        System.out.println("set (1, 'a')");
        array.set(1, "a");
        System.out.println(array.toString());

        array.remove(1);
        System.out.println("remove 1");
        System.out.println(array.toString());

        System.out.println("ref to iterator and print elements");

        Iterator<String> iter = array.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            iter.remove();
        }
        System.out.print("size = ");
        System.out.print(array.size() + "\n");





        System.out.println("index of a");

        System.out.println(array.indexOf("a"));

        System.out.println("clear");
        array.clear();
	

	}

}
