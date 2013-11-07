//implement and algotithm to determine if a string has all unique charachters, What if you cannot use additional data structures

class q1_1 {
  
    public static boolean allCharsUnique(String asciiStr) {
        //create a boolean array for each posible charachter //256 in ascii
        final boolean[] found = new boolean[256];
        
        //iterate through string putting each char into found
        char tmp;
        for (int i = 0; i < asciiStr.length(); i++) {
            tmp = asciiStr.charAt(i);

        //return false if char is already in boolean found array
            if (found[tmp]) {
                return false;
            }
            found[tmp] = true;
        }

        //return true if none found in boolean found array
        return true;
    }

    public static void printTestResult(String test) {
        System.out.println(String.format("%s : has all unique chars ... %b", test, allCharsUnique(test)));
    }

    public static void main(String[] args) {
        printTestResult("string1");
        printTestResult("stringg2");
    }

}