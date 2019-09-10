package ua.nure.shamrai.task2.part3;

import java.util.Iterator;

public class Part3 {
  public static void main(String[] args) {
    Queue<Character> queue = new QueueImpl<>();
    queue.enqueue('A');
    queue.enqueue('B');
    queue.enqueue('C');
    
    System.out.println(queue);
    System.out.println(queue.size());
    System.out.println(queue.top());
    System.out.println(queue.dequeue());
    System.out.println(queue.size());
    System.out.println(queue);
    
    Iterator<Character> it = queue.iterator();
    while(it.hasNext()) {
      System.out.print(it.next());
    }
  }
}
