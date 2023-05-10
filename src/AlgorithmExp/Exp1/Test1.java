package AlgorithmExp.Exp1;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Test1 {
    private static int[][] createMatrix() {
        // Random rand = new Random();
        int rows = 16;
        int cols = 16;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // matrix[i][j] = rand.nextInt(100);
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    // 书写二维数组打印函数
    public static void printArray(int[][] arr) {
        // 采用两个增强for循环配合system.out.printf格式化输出二维数组
        for (int[] row : arr) {
            for (int col : row) {
                System.out.printf("%-2d ", col);
            }
            // 换行
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = createMatrix();
        int[][] matrix2 = createMatrix();
        Instant startTime = Instant.now();
        int[][] result1 = Strassen.strassenMartixMultiplyRecursive(matrix1, matrix2);
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
        startTime = Instant.now();
        int[][] result2 = Normal.squareMatrixMultiply(matrix1, matrix2);
        endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
        System.out.println("Strassen Matrix Mulitple Product");
        printArray(result1);
        System.out.println("Normal Matrix Mulitple Product");
        printArray(result2);
        if (Arrays.deepEquals(result1, result2)) {
            System.out.println("Two Matrix Equal,Algorithm Correct");
        }
    }
}

class Strassen {

    /**
     * Strassen算法的NxN矩阵乘法运算
     * 
     * @param A
     *          参加运算的矩阵之一A
     * @param B
     *          参加运算的矩阵之一B
     * @return
     */
    public static int[][] strassenMartixMultiplyRecursive(int[][] A, int[][] B) {
        int rows = A.length;
        int[][] C = new int[rows][rows];
        if (rows == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[rows / 2][rows / 2];
            int[][] A12 = new int[rows / 2][rows / 2];
            int[][] A21 = new int[rows / 2][rows / 2];
            int[][] A22 = new int[rows / 2][rows / 2];

            copyMatrixbyParamFromSrcToSubMatrix(A, 0, rows / 2, 0, rows / 2, A11);
            copyMatrixbyParamFromSrcToSubMatrix(A, 0, rows / 2, rows / 2, rows / 2, A12);
            copyMatrixbyParamFromSrcToSubMatrix(A, rows / 2, rows / 2, 0, rows / 2, A21);
            copyMatrixbyParamFromSrcToSubMatrix(A, rows / 2, rows / 2, rows / 2, rows / 2, A22);

            int[][] B11 = new int[rows / 2][rows / 2];
            int[][] B12 = new int[rows / 2][rows / 2];
            int[][] B21 = new int[rows / 2][rows / 2];
            int[][] B22 = new int[rows / 2][rows / 2];

            copyMatrixbyParamFromSrcToSubMatrix(B, 0, rows / 2, 0, rows / 2, B11);
            copyMatrixbyParamFromSrcToSubMatrix(B, 0, rows / 2, rows / 2, rows / 2, B12);
            copyMatrixbyParamFromSrcToSubMatrix(B, rows / 2, rows / 2, 0, rows / 2, B21);
            copyMatrixbyParamFromSrcToSubMatrix(B, rows / 2, rows / 2, rows / 2, rows / 2, B22);

            int[][] S1 = new int[rows / 2][rows / 2];
            int[][] S2 = new int[rows / 2][rows / 2];
            int[][] S3 = new int[rows / 2][rows / 2];
            int[][] S4 = new int[rows / 2][rows / 2];
            int[][] S5 = new int[rows / 2][rows / 2];
            int[][] S6 = new int[rows / 2][rows / 2];
            int[][] S7 = new int[rows / 2][rows / 2];
            int[][] S8 = new int[rows / 2][rows / 2];
            int[][] S9 = new int[rows / 2][rows / 2];
            int[][] S10 = new int[rows / 2][rows / 2];

            squareMatrixElementSub(B12, B22, S1);// S1 = B12 - B22
            squareMatrixElementAdd(A11, A12, S2);// S2 = A11 + A12
            squareMatrixElementAdd(A21, A22, S3);// S3 = A21 + A22
            squareMatrixElementSub(B21, B11, S4);// S4 = B21 - B11
            squareMatrixElementAdd(A11, A22, S5);// S5 = A11 + A22
            squareMatrixElementAdd(B11, B22, S6);// S6 = B11 + B22
            squareMatrixElementSub(A12, A22, S7);// S7 = A12 - A22
            squareMatrixElementAdd(B21, B22, S8);// S8 = B21 + B22
            squareMatrixElementSub(A11, A21, S9);// S9 = A11 - A21
            squareMatrixElementAdd(B11, B12, S10);// S10 = B11 + B12

            int[][] P1 = new int[rows / 2][rows / 2];
            int[][] P2 = new int[rows / 2][rows / 2];
            int[][] P3 = new int[rows / 2][rows / 2];
            int[][] P4 = new int[rows / 2][rows / 2];
            int[][] P5 = new int[rows / 2][rows / 2];
            int[][] P6 = new int[rows / 2][rows / 2];
            int[][] P7 = new int[rows / 2][rows / 2];

            P1 = strassenMartixMultiplyRecursive(A11, S1); // P1 = A11 X S1
            P2 = strassenMartixMultiplyRecursive(S2, B22);// P2 = S2 X B22
            P3 = strassenMartixMultiplyRecursive(S3, B11);// P3 = S3 X B11
            P4 = strassenMartixMultiplyRecursive(A22, S4);// P4 = A22 X S4
            P5 = strassenMartixMultiplyRecursive(S5, S6);// P5 = S5 X S6
            P6 = strassenMartixMultiplyRecursive(S7, S8);// P6 = S7 X S8
            P7 = strassenMartixMultiplyRecursive(S9, S10);// P7 = S9 X S10
            // if (rows == 2) {
                System.out.println("Matrix 1:");
                Test1.printArray(P1);
                System.out.println("Matrix 2:");
                Test1.printArray(P2);
                System.out.println("Matrix 3:");
                Test1.printArray(P3);
                System.out.println("Matrix 4:");
                Test1.printArray(P4);
                System.out.println("Matrix 5:");
                Test1.printArray(P5);
                System.out.println("Matrix 6:");
                Test1.printArray(P6);
                System.out.println("Matrix 7:");
                Test1.printArray(P7);
            // }
            int[][] C11 = new int[rows / 2][rows / 2];
            int[][] C12 = new int[rows / 2][rows / 2];
            int[][] C21 = new int[rows / 2][rows / 2];
            int[][] C22 = new int[rows / 2][rows / 2];

            int[][] temp = new int[rows / 2][rows / 2];

            // C11 = P5 + P4 - P2 + P6
            squareMatrixElementAdd(P5, P4, temp);
            squareMatrixElementSub(temp, P2, temp);
            squareMatrixElementAdd(temp, P6, C11);

            // C12 = P1 + P2
            squareMatrixElementAdd(P1, P2, C12);

            // C21 = P3 + P4
            squareMatrixElementAdd(P3, P4, C21);

            // C22 = P5 + P1 - P3 -P7
            squareMatrixElementAdd(P5, P1, temp);
            squareMatrixElementSub(temp, P3, temp);
            squareMatrixElementSub(temp, P7, C22);

            // 将C11/C12/C21/C22四个子矩阵合并为最终的结果C矩阵
            copySubMatrixByParamFromSrcToDest(C11, 0, rows / 2, 0, rows / 2, C);
            copySubMatrixByParamFromSrcToDest(C12, 0, rows / 2, rows / 2, rows / 2, C);
            copySubMatrixByParamFromSrcToDest(C21, rows / 2, rows / 2, 0, rows / 2, C);
            copySubMatrixByParamFromSrcToDest(C22, rows / 2, rows / 2, rows / 2, rows / 2, C);

        }
        return C;
    }

    /**
     * 将一个NxN的大矩阵分解成4个N/2xN/2的子矩阵
     * 
     */
    public static void copyMatrixbyParamFromSrcToSubMatrix(int[][] src, int startI, int lenI, int startJ, int lenJ,
            int[][] dest) {
        for (int i = 0; i < lenI; i++)
            for (int j = 0; j < lenJ; j++) {
                dest[i][j] = src[startI + i][startJ + j];
            }
    }

    /**
     * 将4个N/2xN/2的子矩阵合并成一个NxN的大矩阵
     * 
     */
    public static void copySubMatrixByParamFromSrcToDest(int[][] src, int startI, int lenI, int startJ, int lenJ,
            int[][] dest) {
        for (int i = 0; i < lenI; i++)
            for (int j = 0; j < lenJ; j++) {
                dest[startI + i][startJ + j] = src[i][j];
            }
    }

    /**
     * NxN矩阵加法
     * 
     * @param srcA
     *             加法源矩阵之一
     * @param srcB
     *             加法源矩阵之二
     * @param dest
     *             矩阵加法结果
     */
    public static void squareMatrixElementAdd(int[][] srcA, int[][] srcB, int[][] dest) {
        for (int i = 0; i < srcA.length; i++)
            for (int j = 0; j < srcA[i].length; j++)
                dest[i][j] = srcA[i][j] + srcB[i][j];
    }

    /**
     * NxN矩阵减法
     * 
     * @param srcA
     *             减法源矩阵之一
     * @param srcB
     *             减法源矩阵之二
     * @param dest
     *             矩阵减法结果
     */
    public static void squareMatrixElementSub(int[][] srcA, int[][] srcB, int[][] dest) {
        for (int i = 0; i < srcA.length; i++)
            for (int j = 0; j < srcA[i].length; j++)
                dest[i][j] = srcA[i][j] - srcB[i][j];
    }
}

class Normal {
    /**
     * 一般的暴力矩阵乘法运算;矩阵A和B都是NxN的方阵
     * 
     * @param A
     *          参加运算的矩阵之一A
     * @param B
     *          参加运算的矩阵之一B
     * @return
     *         矩阵A和B相乘得到的矩阵C
     */
    public static int[][] squareMatrixMultiply(int[][] A, int[][] B) {

        int rows = A.length;
        int[][] C = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                C[i][j] = 0;
                for (int k = 0; k < rows; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
