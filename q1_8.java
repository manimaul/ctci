//assume you have a method isSubString which checks if one word is a substring of another.  Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat")

class q1_8 {
	
	public static boolean isSubString(String s1, String s2) {
		//is s1 a sub-string of s2
		int index = s2.indexOf(s1);
		if (index == -1) {
			return false;
		}
		return true;
	}

	//answer
	public static boolean isStringRotation(String s1, String s2) {
		return isSubString(s1, s2 + s2);
	}

	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		System.out.println(String.format("str2 is rotation of str1: %b", isStringRotation(str1, str2)));
	}
}