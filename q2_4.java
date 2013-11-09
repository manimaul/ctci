//Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.

class q2_4 {

	//answer - Note: the book's answer shows creating two lists and then joining them.  However, I think this solution is cleaner.
	public static void partitionAroundX(DoublyLinkedList<Integer> pList, Integer pX) {
		Node<Integer> runner = pList.head;
		Node<Integer> temp;
		while (runner != null) {
			if (runner.data <= pX) {
				temp = runner;
				runner = runner.next;

				pList.addFirst(temp.data);
				pList.delete(temp);
			} else {
				runner = runner.next;
			}
			
		}
	}

	public static void main(String[] args) {
		//create a linked list of 25 random integers between 0 and 99
		DoublyLinkedList<Integer> intList = new DoublyLinkedList<Integer>();
		int min = 0;
		int max = 99;
		for (int i = 0; i < 25; i++) {
			intList.addFirst(new Integer(min + (int)(Math.random() * ((max - min) + 1))));
		}

		System.out.print("\nun-partitioned");
		printList(intList);
		partitionAroundX(intList, new Integer(50));
		System.out.print("\npartitioned");
		printList(intList);
	}

	public static void printList(DoublyLinkedList<Integer> pList) {
		System.out.println("\n--------------");
		Node<Integer> runner = pList.head;
		if (runner == null) {
			System.out.println("list is empty");
			return;
		}
		while (runner != null) {
			System.out.print(String.format("%02d<->", runner.data));
			runner = runner.next;
		}
		System.out.println("\n--------------");

	}
}

class DoublyLinkedList<E> {
	Node<E> head;
	Node<E> tail;

	public void delete(Node<E> node) {
		if (node.next != null) {
			if (head == node) {
				head = node.next;
			}
			node.next.prev = node.prev;
		}
		if (node.prev != null) {
			if (tail == node) {
				tail = node.prev;
			}
			node.prev.next = node.next;
		}
	}

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