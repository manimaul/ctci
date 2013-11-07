//given 2 strings write a method to determin if one is a permutation of the other

import java.util.HashMap;

class q1_3 {

    //answer part
    public static void incrementValueForKey(HashMap<Integer, Integer> pMap, Integer pKey) {
        if (pMap.containsKey(pKey)) {
                pMap.put(pKey, pMap.get(pKey)+1);
        } else {
            Integer val = new Integer(1);
            pMap.put(pKey, val);
        }
        System.out.println(String.format("key %d, val %d", pKey, pMap.get(pKey)));
    }

    //answer
    public static boolean isPermutationOf(String str1, String str2) {
        //if they're different lenghts return false
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Integer, Integer> str1Chars = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> str2Chars = new HashMap<Integer, Integer>();

        //create two key value dictionaries with the char
        for (int i=0; i<str1.length(); i++) {
            incrementValueForKey(str1Chars, new Integer(str1.charAt(i)));
            incrementValueForKey(str2Chars, new Integer(str2.charAt(i)));
        }

        //compare the two dictionaries and return false if they don't have the same keys or the key values differ
        for (Integer key : str1Chars.keySet()) {
            System.out.println(String.format("key %d", key));
            if (!str2Chars.containsKey(key) || (str2Chars.get(key).intValue() != str1Chars.get(key).intValue()) ) {
                return false;
            }   
        }

        return true;
    }

    public static void main(String[] args) {
        String t1 = "tezst";
        String t2 = "esttz";
        System.out.println(String.format("%s is permutation of %s... %b", t1, t2, isPermutationOf(t1, t2)));
    }
}