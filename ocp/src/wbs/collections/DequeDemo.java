package wbs.collections;

import java.util.ArrayDeque;

public class DequeDemo {
	public static void main(String[] args) {
		// bei einer deque ist zugriff an beiden enden möglich
		// XXXFirst() operiert auf dem head
		// XXXLast operiert auf dem tail
		// addFirst(), offerFirst() fügen am head ein
		// addlast(), offerLast() fügen am tail ein
		// removeFirst(), pollFirst() entnehmen vom head
		// removeLast(), pollLast() entnehmen vom tail
		// getFirst(), peekFirst() untersuchen den head
		// getLast(), peekLast() untersuchen den tail
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		System.out.println(deque);  // [4, 3, 2, 1]
		// head jetzt: 4 3 2 1
		deque.addLast(10);
		deque.addLast(11);
		deque.addLast(12);
		deque.addLast(13);
		System.out.println(deque);  // [4, 3, 2, 1, 10, 11, 12, 13]
		// tail jetzt: 10 11 12 13
		System.out.println(deque.getFirst()); // 4
		System.out.println(deque.getLast()); // 13
		System.out.println("---------");
		// die gesamte deque jetzt: 4 3 2 1 10 11 12 13
		while (!deque.isEmpty()) {
			System.out.println(deque.removeFirst());
		}
	}
}