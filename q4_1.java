//Implement a function to check if a binary tree is balanced.  For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.

import java.util.LinkedList;
import java.util.Queue;

class q4_1 {
	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<Integer>(0);
		root.addLeft(1).addLeft(3);
		root.addRight(2);
		root.print();

		root = new BinaryTree<Integer>(0);
		root.addLeft(1).addLeft(3).addLeft(4);
		root.addRight(2);
		root.print();
	}
}

class BinaryTree<E> {
	public E data;
	private BinaryTree<E> leftChild;
	private BinaryTree<E> rightChild;

	public BinaryTree(E e) {
		data = e;
	}

	public BinaryTree<E> addLeft(E e) {
		BinaryTree<E> b = new BinaryTree<E>(e);
		leftChild = b;
		return leftChild;
	}

	public BinaryTree<E> addRight(E e) {
		BinaryTree<E> b = new BinaryTree<E>(e);
		rightChild = b;
		return rightChild;
	}

	public boolean isLeaf() {
		return (leftChild == null && rightChild == null);
	}

	public int depth() {
		int left = 0;
		if (leftChild != null) {
			left = leftChild.depth() + 1;
		}

		int right = 0;
		if (rightChild != null) {
			right = rightChild.depth() +1;
		}

		return Math.max(left, right);
	}

	public int breadthCount() {
		Queue<BinaryTree<E>> queue = new LinkedList<BinaryTree<E>>();
		BinaryTree<E> node = this;
		queue.offer(node); //add to back of queue
		int count = 0;

		//for each depth count left to right
		while (queue.size() > 0) {
			node = queue.poll(); //remove from front of queue
			count ++;
			if (node.rightChild != null) {
				queue.offer(node.rightChild);
			}
			if (node.leftChild != null) {
				queue.offer(node.leftChild);
			}
		}
		return count;
	}

	//answer q4_1
	/**
	* Returns balanced defined as depths of any two child sub-trees 
	* never differ more than 1.
	* @return -1 if unBalanced, the depth of the tree if not balanced
	*/
	public int isBalanced() {
		int leftHeight = 0;
		if (leftChild != null) {
			leftHeight=leftChild.isBalanced();
			if (leftHeight == -1) {
				return -1;
			}
		}

		int rightHeight = 0;
		if (rightChild != null) {
			rightHeight = rightChild.isBalanced();
			if (rightHeight == -1) {
				return -1;
			}
		}

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1 ) {
			return -1;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public void print() {
        print(this, 0);
        System.out.println("-----------------");
		System.out.println(String.format("total nodes: %d", breadthCount()));
		int depth = isBalanced();
		System.out.println(String.format("balanced?: %b", depth != -1));
		if (depth == -1)
			depth = depth();
		System.out.println(String.format("depth: %d", depth));
    }
    
    private void print(BinaryTree<E> node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }
        if (node == null) {
            System.out.println("null");
            return;
        }
        System.out.println(node.data);
        if (node.isLeaf()) return;
        print(node.leftChild, indent + 1);
        print(node.rightChild, indent + 1);
    }

}