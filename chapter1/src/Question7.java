import static java.lang.Math.random;

public class Question7 {

    // the provided code is easy to read and understand
    // the idea is clear:
    //  set up two boolean arrays
    //  go through all elements and if there is a zero, then locate the index in boolean arrays to be true
    //  based on the boolean arrays, nullify the matrix
    // the time complexity is O(m*n) <= m * n + m + n
    // the space complexity is O(m) or O(n) whichever is bigger

    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
//        System.out.println("row size: " + row.length);
//        System.out.println("column size: " + column.length);

        // store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    public static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }


    public static int[][] mySetZeros(int[][] matrix) {
        int matrixRowSize = matrix.length;
//        System.out.println("matrix row size: " + matrixRowSize);
        int matrixColumnSize = matrix[0].length;
//        System.out.println("matrix column size: " + matrixColumnSize);

        int[][] result = new int[matrixRowSize][matrixColumnSize];
        for (int i = 0; i < matrixRowSize; i++) {
            for (int j = 0; j < matrixColumnSize; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int rowIndex = 0; rowIndex < matrixRowSize; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrixColumnSize; columnIndex++) {
                if (matrix[rowIndex][columnIndex] == 0) {
                    nullifyColumn(result, columnIndex);
                    nullifyRow(result, rowIndex);
                }
            }
        }

        return result;
    }

    public static String printMatrix(int[][] matrix) {
        StringBuffer matrixBuffer = new StringBuffer();
        matrixBuffer.append("print matrix:" + System.lineSeparator());

        int rowSize = matrix.length;
        int columnSize = matrix[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                matrixBuffer.append(matrix[i][j]);
                matrixBuffer.append(" ");
            }
            matrixBuffer.append(System.lineSeparator());
        }
        return matrixBuffer.toString();
    }

    public static void main(String args[]) {
        // create a matrix
        // rowLength means the number of rows
        // columnLength means the number of columns
        int rowLength = 3;
        int columnLength = 4;
        int[][] matrix = new int[rowLength][columnLength];
        int[][] matrix2 = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                matrix[i][j] = (int) (Math.random()*10);
            }
        }

        matrix[1][2] = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                matrix2[i][j] = matrix[i][j];
            }
        }

        System.out.println("=======original matrix:=======");
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=======setZeros matrix:=======");
        setZeros(matrix);

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=======mySetZeros matrix:=======");
        int[][] myMatrix = mySetZeros(matrix2);
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}

