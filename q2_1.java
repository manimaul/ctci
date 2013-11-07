//Write code to remove duplicases from an unsorted linked list.  
//FOLLOW UP
//How would you solve this problem if a temporary buffer is not allowed?

import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Iterator;

class q2_1 {

	//answer
	public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> pLinkedList) {
		
		//put items into an ordered set 
		LinkedHashSet<Integer> unique = new LinkedHashSet<Integer>(pLinkedList);

		//return the ordered set as a linked list
		return new LinkedList<Integer>(unique);
	}

	//another answer - more memory efficient and can take any take of LinkedList Object node type
	public static void removeDuplicates2(LinkedList pLinkedList) {
		//create a set for unique objects
		HashSet<Object> unique = new HashSet<Object>();

		//iterate over linked list removing duplicates found
		Iterator itr = pLinkedList.listIterator();
		Object obj;
		while (itr.hasNext()) {
			obj = itr.next();
			if (unique.contains(obj)) {
				itr.remove();
			} else {
				//add to unique
				unique.add(obj);
			}
		}
	}

	public static void printLinkedList(LinkedList<Integer> pLinkedList) {
		System.out.println("-----------------");
		for (Integer i : pLinkedList) {
			System.out.print(String.format("%02d ", i.intValue()));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList<Integer> intList = new LinkedList<Integer>();
		intList.add(new Integer(2));
		intList.add(new Integer(1));
		intList.add(new Integer(2));
		intList.add(new Integer(3));

		printLinkedList(intList);
		removeDuplicates2(intList);
		//intList = removeDuplicates(intList);
		printLinkedList(intList);
	}
}