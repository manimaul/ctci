//You have two numbers represented by a linked list, where each node contains a single digit.  The digits are sorted in reverse order, such that the 1's digit is at the head of the list.  Write a function that adds the two numbers and returns the sum as a linked list.
//EXAMPLE
//Input 7->1->6 + 5->9->2... That is 617 + 295
//Output 2->1->9... That is 912

class q2_5 {

	//answer part - evaluate int as list of 10s place ints
	public static DoublyLinkedList<Integer> integerToList(Integer pInt) {
		DoublyLinkedList<Integer> intList = new DoublyLinkedList<Integer>();
		while(pInt > 0) {
        	intList.addLast(pInt % 10);
        	pInt /= 10;
    	}
		return intList;
	}


	//answer part - evaluate list as int
	public static Integer evalIntList(DoublyLinkedList<Integer> pList1) {
		Integer sum = 0;
		Node<Integer> runner = pList1.head;
		Integer multiple = 1;
		while (runner != null) {
			sum += runner.data * multiple;
			runner = runner.next;
			multiple *= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> intList1 = new DoublyLinkedList<Integer>();
		addArrayToList(new int[] {6, 1, 7}, intList1);
		printList(intList1);
		DoublyLinkedList<Integer> intList2 = new DoublyLinkedList<Integer>();
		addArrayToList(new int[] {2, 9, 5}, intList2);
		printList(intList2);
		Integer sum1 = evalIntList(intList1);
		Integer sum2 = evalIntList(intList2);
		printList(integerToList(sum1 + sum2));
	}

	public static void addArrayToList(int[] pArr, DoublyLinkedList<Integer> pList) {
		for (int i: pArr) {
			pList.addFirst(i);
		}
	}

	public static void printList(DoublyLinkedList<Integer> pList) {
		Node<Integer> runner = pList.head;
		while (runner != null) {
			System.out.print(String.format("%d->", runner.data));
			runner = runner.next;
		}
		System.out.println("\n--------------");

	}
}

class DoublyLinkedList<E> {
	Node<E> head;
	Node<E> tail;

	public Node<E> addFirst(E data) {
		Node<E> node = new Node<E>(data);
		if (head != null) {
			node.next = head;
			head.prev = node;
		}
		if (tail == null) {
			tail = node;
		}
		head = node;
		return node;
	}

	public Node<E> addLast(E data) {
		Node<E> node = new Node<E>(data);
		if (tail != null) {
			node.prev = tail;
			tail.next = node;
		}
		if (head == null) {
			head = node;
		}
		tail = node;
		return node;
	}

}

class Node<E> {
	Node<E> next;
	Node<E> prev;
	E data;

	public Node(E e) {
		data = e;
	}

}