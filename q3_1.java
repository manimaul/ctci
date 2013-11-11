
class q3_1 {

	//demonstration of implementation 
	public static void main(String[] args) {
		String str = "\nnoitartsnomed\n";
		TripleStackArray tsa = new TripleStackArray(str.length());
		try {
			for (int i = 1; i <= 3; i++) {
				for (int n = 0; n < str.length(); n++) {
					tsa.push(str.charAt(n), i);
					System.out.print(tsa.peek(i));
				}
				for (int x = 0; x < str.length(); x++) {
					System.out.print(tsa.pop(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

//answer
//Create an array of fixed size * 3, track section size.
//Write methods to retrieve stack index in array based on tracked size
//Write methods to track size of 3 stacks
class TripleStackArray {

	final Object[] mArray;
	int ssz1 = 0; //stack 1 size
	int ssz2 = 0;
	int ssz3 = 0;

	public TripleStackArray(int stackSize) {
		mArray = new Object[stackSize * 3];
	}
	
	private int getIndexForStack(int pStackNumber) throws Exception {
		int index;
		
		switch (pStackNumber) {
			case 1:
			index = ssz1 - 1;
			break;
			
			case 2:
			index = mArray.length / 3 + ssz2 - 1;
			break;

			case 3:
			index = mArray.length / 3 * 2 + ssz3 - 1;
			break;

			default:
			throw new Exception("no such stack number");
		} 

		return index;
	}

	private void setSizeForStack(int pStackNumber, int size) throws Exception {
		int maxSize = mArray.length / 3;

		if (size > maxSize)
			throw new Exception("stack size limit reached");
		else if(size < 0) {
			throw new Exception("stack size cannot be less than 0");
		}

		switch (pStackNumber) {
			case 1:
			ssz1 = size;
			break;

			case 2:
			ssz2 = size;
			break;

			case 3:
			ssz3 = size;
			break;

			default:
			throw new Exception("no such stack number");
		}

	}

	private int getSizeForStack(int pStackNumber) throws Exception {
		int size;
		
		switch (pStackNumber) {
			case 1:
			size = ssz1;
			break;

			case 2:
			size = ssz2;
			break;

			case 3:
			size = ssz3;
			break;

			default:
			throw new Exception("no such stack number");

		}
		return size;
	}

	public Object pop(int pStackNumber) throws Exception {
		int index = getIndexForStack(pStackNumber);
		int size = getSizeForStack(pStackNumber);
		setSizeForStack(pStackNumber, size - 1);
		return mArray[index];
	}

	public void push(Object pObj, int pStackNumber) throws Exception {
		int size = getSizeForStack(pStackNumber);
		setSizeForStack(pStackNumber, size + 1);
		int index = getIndexForStack(pStackNumber);
		mArray[index] = pObj;

	}

	public Object peek(int pStackNumber) throws Exception {
		int index = getIndexForStack(pStackNumber);
		return mArray[index];
	}
 
}