//Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.  Implement a data structre SetOfStacks that mimics this.  SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.  SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as if it were just a single stack.)
//FOLLOWUP
//Implment a popAt(int index) which performs a pop operation on a specific sub-stack

import java.util.ArrayList;

class q3_3 {

	//demonstration of functionality
	public static void main(String[] args) {
		SetOfStacks<Integer> sos = new SetOfStacks<Integer>(3);
		Integer[] values = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for ( Integer n:  values) {
			sos.push(n);
		}

		System.out.println(String.format("should be null: %d", sos.popAt(3)));
		System.out.println(String.format("should be 3: %d", sos.popAt(0)));
		System.out.println(String.format("should be 6: %d", sos.popAt(1)));
		System.out.println(String.format("should be 9: %d", sos.popAt(2)));

		Integer n = sos.pop();
		while (n != null) {
			System.out.print(String.format("%d ", n));
			n = sos.pop();
		}
	}

}

//answer + followup - all classes below here

class SetOfStacks<E> {
	private final ArrayList<Stack<E>> stackList = new ArrayList<Stack<E>>();
	private final int stackCap;
	public int count;
	
	public SetOfStacks(int pStackCap) {
		stackCap = pStackCap;
		stackList.add(new Stack<E>(stackCap));
	}

	public Node<E> push(E e) {
		Stack<E> stack = getTopStack();
		
		if (stack.count == stack.capacity) {
			stack = new Stack<E>(stackCap);
			stackList.add(stack);
		}

		return stack.push(e);
	}

	private Stack<E> getTopStack() {
		int size = stackList.size();
		if (size > 0) {
			return stackList.get(size - 1);
		}

		return null;
	}

	public E popAt(int pIndex) {
		if (stackList.size() -1 < pIndex)
			return null;

		Stack<E> stack = stackList.get(pIndex);
		E e = stack.pop();

		if (stack.count == 0 && 
			stackList.size() > 1) {
			stackList.remove(pIndex);
		}

		return e;
	}

	public E pop() {
		Stack<E> stack = getTopStack();
		E e = stack.pop();

		if (stack.count == 0 && 
			stackList.size() > 1) {
			stackList.remove(stackList.size()-1);
		}

		return e;
	}

}

class Stack<E> {
	private Node<E> top;
	public int capacity;
	public int count = 0;

	public Stack(int pCapacity) {
		capacity = pCapacity;
	}

	public Node<E> push(E e) {
		Node<E> node = new Node<E>(e);
		if (top != null) {
			node.next = top;
		}
		top = node;
		count++;
		return node;
	}

	public E pop() {
		E e = null;
		if (top != null) {
			e = top.data;
			top = top.next;
		}
		count--;
		return e;
	}

}

class Node<E> {
	Node<E> next;
	E data;

	public Node(E e) {
		data = e;
	}

}