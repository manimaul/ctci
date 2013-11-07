//Given an image represented by an NxN matrix where each pixel in the image is 4 bytes, write a method to rotate the image 90 degrees.  Can you do this in place?

class q1_6 {

    //answer
    public static void rotateMatrix(int[][] matrix) {
        int layers = matrix.length / 2;
        int size = matrix.length-1;
        int tmpMe;

        for (int i = 0; i < layers; i++) {
            //i is the current layer
            for (int n = 0; n < layers; n++) {
                //cache me
                tmpMe = matrix[i][n];
                
                if (i==n) {
                    //set me to value of next
                    matrix[i][n] = matrix[size-i][n];

                    //set next to the value of opposite
                    matrix[size-i][n] = matrix[size-i][size-n];

                    //set opposite to the value of previous
                    matrix[size-i][size-n] = matrix[i][size-n];

                    //set previous to the value of me
                    matrix[i][size-n] = tmpMe;
                } else {
                    //set me to value of next
                    matrix[i][n] = matrix[size-n][i];

                    //set next to the value of opposite
                    matrix[size-n][i] = matrix[size-i][size-n];

                    //set opposite to the value of previous
                    matrix[size-i][size-n] = matrix[n][size-i];

                    //set previous to the value of me
                    matrix[n][size-i] = tmpMe;
                }
                

            }
        }

    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("=============================");
        for (int i = 0; i < matrix.length; i++) {
            for (int n = 0; n < matrix.length; n++) {
                System.out.print(String.format("%02d  ", matrix[i][n]));
            }
            System.out.println();   
        }
        System.out.println("=============================");
    }

    public static void main (String[] args) {
        int[][] matrix = { { 0,  1,  2,  3,  4,  5  },
                           { 6,  7,  8,  9,  10, 11 },
                           { 12, 13, 14, 15, 16, 17 },  
                           { 18, 19, 20, 21, 22, 23 },
                           { 24, 25, 26, 27, 28, 29 },
                           { 30, 31, 32, 33, 34, 35 }  };
        printMatrix(matrix);
        rotateMatrix(matrix);
        printMatrix(matrix);
    }
}