//How would you design a stack which, in addition to push and pop, also as a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.

class q3_2 {
	
	//demonstration
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		Integer[] values = new Integer[] {14, 99, 24, 56, 4, 9, 1, 0};
		for ( Integer n:  values) {
			ms.push(n);
			System.out.println(String.format("pushing: %d on stack", n));
			System.out.println(String.format("stack min is: %d", ms.min()));
			System.out.println("-----");
		}

		Integer i;
		for (Integer n: values) {
			i = ms.pop().data;
			System.out.println(String.format("popping: %d from stack", i));
			System.out.println(String.format("stack min is: %d", ms.min()));
			System.out.println("-----");
		}

	}

}

//answer
class MinStack {

	public Node top;

		public Node push(Integer d) {
			Node node = new Node(d);
			if (top != null) {
				node.min = Math.min(top.min, d);
				node.next = top;
			} else {
				node.min = d;
			}
			top = node;
			return node;
		}

		public Node pop() {
			Node node = top;

			if (top != null) {
				top = node.next;
			}
			
			return node;
		}

		public Node peek() {
			return top;
		}

		public Integer min() {
			if (top != null)
				return top.min;

			return null;
		}

	class Node {

		public Node next;
		public Integer data;
		public Integer min;

		public Node(Integer d) {
			data = d;
		}

	}

}