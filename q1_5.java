//implement a method to perform basic string compression using the counts of repeated characters.  For example, the string aabccccaaa would become a2b1c4a3.  If the compressed string would not become smaller then return the original.

class q1_5 {
    
    public static String compressString(String pStr) {
        //loop through pStr looking forward at each character
        //if look ahead is 
        StringBuilder sb = new StringBuilder();

        int fp = 0;  //forward position
        char fwd;    //look ahead charachter;
        char cur;    //current charachter;
        int rc = 1;  //repeat count

        sb.append(pStr.charAt(0));
        for (int i = 0; i < pStr.length(); i++ ) {
            fp = i + 1;
            if ( fp < pStr.length() ) {
                fwd = pStr.charAt(fp);
                cur = pStr.charAt(i);
                if (cur == fwd) {
                    rc += 1;
                } else {
                    //we have a new charachter;
                    sb.append(rc);  //append count of last
                    sb.append(fwd); //append forward char
                    rc = 1;
                }
            } else {
                sb.append(rc); //append count of last
            }
        }

        String result = sb.toString();

        if (result.length() >= pStr.length())
            return pStr;

        return result;
        

    }

    public static void main(String[] args) {
        String compressme = "aabccccaaa";
        System.out.println(compressString(compressme));
        compressme = "hello";
        System.out.println(compressString(compressme));

    }
}