//Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
//DEFINITION:
//Circular linked list: A (Corrupt) linked list in which a node's next pointer points to an earlier node so as to make a loop in the linked list.
//EXAMPLE:
//Input: a->b->c->d->e->f->g->h->i->d (the same d as earlier)
//Output: d

class q2_6 {
	public static CorruptList.Node findCircularStart(CorruptList pList) {
		CorruptList.Node runner = pList.head;
		CorruptList.Node fastRunner = pList.head;

		//find the first collision with fastRunner twice as fast as runner
		while (runner != null && fastRunner.next != null) {
			fastRunner = fastRunner.next;

			if (runner == fastRunner) {
					break;
			}

			fastRunner = fastRunner.next;
			runner = runner.next;
		}

		//place runner at the head and move runners at the same speed until we reach a second collision
		runner = pList.head;

		while (runner != null && fastRunner != null) {
			fastRunner = fastRunner.next;

			if (runner == fastRunner) {
				return runner;
			}

			runner = runner.next;
		}

		//list is not circular
		return null;
	}

	public static void main (String[] args) {
		CorruptList cList = new CorruptList();
		CorruptList.Node node = findCircularStart(cList);
		if (node != null)
			System.out.println(String.format("corrupt node data:%c", node.data));
		else 
			System.out.println("list is not circular");
		printList(cList);
	}

	public static void printList(CorruptList pList) {
		CorruptList.Node runner = pList.head;
		for (int i = 0; i < 10; i++) {
			System.out.print(String.format("%c->", runner.data));
			runner = runner.next;
		}
		System.out.println("\n--------------");
	}
}

class CorruptList {
	Node head;
	public CorruptList() {
		Node tmp = add('i');
		add('h');
		add('g');
		add('f');
		add('e');
		tmp.next = add('d');
		add('c');
		add('b');
		add('a');
	}

	public Node add(char pChar) {
		Node node = new Node(pChar);
		if (head != null) {
			node.next = head;
		}
		head = node;
		return node;
	}

	class Node {
		Node next;
		char data;
		public Node(char pChar) {
			data = pChar;
		}
	}

}

