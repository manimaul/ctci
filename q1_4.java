//write a method to replace all spaces in a string with %20.  Assume that the string has sufficient space to hold the additional characters and you know the true lenght of the string. Method must ber perfomed in place. (Use a char array in java)

class q1_4 {
    public static void encodeUrlSpaces(char[] str, int length) {
        //scan and count number of spaces
        int newLength = length;
        int i;
        for (i=0; i < length; i++) {
            if (str[i] == ' ') {
                newLength += 3;
            }
        }

        //create a temp array with total size
        char[] tmp = new char[newLength];

        //push appropriate chars into temp array looping through str for lenght
        int p = 0;
        for (i=0; i < length; i++) {
            if (str[i] == ' ') {
                tmp[p] = '%';
                tmp[p+1] = '2';
                tmp[p+2] = '0';
                p += 3;
            } else {
                tmp[p] = str[i];
                p += 1;
            }
        }

        //copy temp array into original
        for (i=0; i < newLength; i++) {
            str[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        char[] str = "Mr John Smith      ".toCharArray();
        int length = 13;

        System.out.println(new String(str));
        encodeUrlSpaces(str, length);
        System.out.println(new String(str));
    }
}