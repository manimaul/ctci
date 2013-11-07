//Implement an algorithm to find the kth to last element of a lingly linked list

import java.util.LinkedList;
import java.util.Iterator;

class q2_2 {
	
	//answer if we don't know the length of the linked list
	public static Integer findKthElement2(LinkedList<Integer> pLinkedList, int kth) {
		//create a queue the size of kth
		LinkedList<Integer> queue = new LinkedList<Integer>();

		//push objects onto queue until the end of the list
		Iterator itr = pLinkedList.listIterator();
		int count = 0;
		while (itr.hasNext()) {
			queue.addLast((Integer) itr.next());
			if (count > kth) {
				queue.removeFirst();
			}
			count++;
		}

		//return the 1st object in queue if count of objects > kth
		if (count > kth) {
			return queue.peekFirst();
		}

		return null;
	}

	//answer if we know the length of the linked list
	public static Integer findKthElement(LinkedList<Integer> pLinkedList, int kth) {
		//if kth is larger than the list's last index return null
		if (pLinkedList.size() - 1 < kth) {
			return null;
		}

		Iterator itr = pLinkedList.listIterator();
		int i = 0; //index
		int t = pLinkedList.size() - kth - 1; //index target 1
		while (itr.hasNext()) {
			if (i == t) {
				return (Integer) itr.next();
			}
			itr.next();
			i++;
		}

		return null;
	}

	public static void main(String[] args) {
		//pretend that this is a singly linked list
		//http://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
		LinkedList<Integer> intList = new LinkedList<Integer>();

		intList.add(new Integer(0)); //5th from last
		intList.add(new Integer(1)); //4th from last
		intList.add(new Integer(2)); //3rd from last
		intList.add(new Integer(3)); //2nd from last
		intList.add(new Integer(4)); //1st from last
		intList.add(new Integer(5)); //0th from last

		for (int i=0; i < 5; i++ ) {
			System.out.println(String.format("%d from last", i));
			System.out.println(String.valueOf(findKthElement2(intList, i)));
			System.out.println(String.valueOf(findKthElement(intList, i)));
		}

	}

}