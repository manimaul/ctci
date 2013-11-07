import java.util.HashSet;

//write an algorithm such that if an element in a MxN matrix is 0, it's entire row and column are set to 0

class q1_7 {
    
    public static void zeroRowAndCol(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        //search for 0s and cache row and col number
        HashSet<Integer> zRows = new HashSet<Integer>();
        HashSet<Integer> zCols = new HashSet<Integer>();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (matrix[r][c] == 0) {
                    Integer row = new Integer(r);
                    if (!zRows.contains(row)) {
                        zRows.add(row);
                    }
                    Integer col = new Integer(c);
                    if (!zCols.contains(col)) {
                        zCols.add(col);
                    }
                }
            }
        }

        //zero out columns in zCol set 
        for (Integer col : zCols) {
            for (int i=0; i < numRows; i++) {
                matrix[i][col.intValue()] = 0;
            }
        }

        //zero out rows in zRow set
        for (Integer row : zRows) {
            for (int i=0; i< numCols; i++) {
                matrix[row.intValue()][i] = 0;
            }
        }

    }

    public static void printMatrix(int[][] matrix) {
        int numCols = matrix.length;
        int numRows = matrix[0].length;

        System.out.println("=============================");
        for (int i = 0; i < numCols; i++) {
            for (int n = 0; n < numRows; n++) {
                System.out.print(String.format("%02d  ", matrix[i][n]));
            }
            System.out.println();   
        }
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        //6x5 matrix
        int[][] matrix = { { 0,  1,  2,  3,  4,  5  },
                           { 6,  7,  8,  9,  10, 11 },
                           { 12, 13, 14, 0,  16, 17 },  
                           { 18, 19, 20, 21, 22, 23 },
                           { 24, 25, 26, 27, 28, 29 } };
        printMatrix(matrix);
        zeroRowAndCol(matrix);
        printMatrix(matrix);
    }
}