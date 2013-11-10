//implement an algorithm to detect if a linked list is palindrone

class q2_7 {

	//answer - for doubly linked list, dispatch runners at each end and evaluate equivilancy as they traverse to the center

	//answer - for singly linked list...
	public static boolean isPalindrone(LinkedList pList) {
		//send a runner to the mid point creating a second linked list along the way
		LinkedList.Node runner = pList.head;
		if (runner == null)
			return false;

		int pos = 0;
		LinkedList halfList = new LinkedList();
		while(runner != null && pos < (pList.count / 2) ) {
			halfList.add(runner.data);
			pos ++;
			runner = runner.next;
		}

		if (runner != null) {
			runner = runner.next;
		}

		//dispatch a second runner and evaluate equivilancy of both runners as they traverse
		LinkedList.Node runner2 = halfList.head;
		while(runner != null && runner2 != null) {
			
			if (runner2.data != runner.data) {
				
				return false;
			}
			runner = runner.next;
			runner2 = runner2.next;
		}

		return true;
	}

	public static void main(String[] args) {
		LinkedList paliList = new LinkedList();
		paliList.addAll((new int[] {1,2,3,4,3,2,1}));
		System.out.println(String.format("list1 is palindrone: %b", isPalindrone(paliList) ));

		LinkedList nPaliList = new LinkedList();
		nPaliList.addAll((new int[] {1,2,3,4,1,2,3}));
		System.out.println(String.format("list2 is palindrone: %b", isPalindrone(nPaliList) ));
	}
}

class LinkedList {
	Node head;
	int count = 0;

	public void addAll(int[] p) {
		for (int i : p) {
			add(i);
		}
	}

	public void add(int p) {
		Node node = new Node(p);
		if (head != null) {
			node.next = head;
		}
		head = node;
		count ++;
	}

	class Node {
		Node next;
		int data;
		public Node(int p) {
			data = p;
		}
	}
}