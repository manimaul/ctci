//Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
//EXAMPLE
//Input: the node c from the linked list a->b->c->d->e
//Result: nothing is returned, but the new linked list looks like  a->b->d->e

class q2_3 {

	public static void printList(SinglyLinkedList<String> pList) {
		SinglyLinkedList.Node runner = pList.head;
		if (runner == null) {
			System.out.println("list is empty");
			return;
		}
		while (runner != null) {
			System.out.print(String.format("%s->", runner.element));
			runner = runner.next;
		}
		System.out.println();

	}

	public static void main (String[] args) {

		SinglyLinkedList<String> lettersList = new SinglyLinkedList<String>();
		lettersList.addFirst("e");
		lettersList.addFirst("d");
		SinglyLinkedList.Node deleteMe = lettersList.addFirst("c");
		lettersList.addFirst("b");
		lettersList.addFirst("a");

		printList(lettersList);
		deleteMe.delete();
		printList(lettersList);
	}

}

//This is a simple linked list implementation containing a pointer to head and a pointer to tail
//it is LIFO - last in first out
class SinglyLinkedList<E> {

	public Node<E> head = null;
	public Node<E> tail = null;

	public Node<E> addFirst(E e) {
		Node<E> node = new Node<E>(e);

		if (head == null) {
			tail = node;
		} else {
			node.next = head;
		}

		head = node;

		return node;
	}

	class Node<E> {
		public Node<E> next;
		public E element;

		public Node(E e) {
			element = e;
		}

		//answer
		public void delete() {
			if (next != null) {
				//copy the next nodes data into ourself then remove the next node
				element = next.element;
				next = next.next;	
			}
		}

	}

}