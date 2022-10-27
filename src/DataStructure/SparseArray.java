package DataStructure;

public class SparseArray {
    // 主函数：负责打印原始数组，转换后的稀疏数组，以及在转换回来的二维数组
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("预览原始数组：");
        printChessArray(chessArr);

        int[][] sparseArr = chessToSparse(chessArr);
        System.out.println("二维数组转稀疏数组");
        printChessArray(sparseArr);

        int[][] chessArr2 = sparseToChess(sparseArr);
        System.out.println("稀疏数组转二维数组");
        printChessArray(chessArr2);
    }

    // 二维数组转稀疏数组：
    // 1. 记录有效数字的个数sum
    // 2. 创建稀疏数组int[sum+1][3]
    // 3. 记录chessRow和chessCol以及有效数字count
    // 4. 遍历数组,为稀疏数组sparseArr赋值
    // 5. 返回稀疏数组
    private static int[][] chessToSparse(int[][] chessArr) {
        int sum = 0;
        for (int[] row : chessArr) {
            for (int chess : row) {
                if (chess != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArr = new int[sum + 1][3];
        int chessRow = chessArr.length;
        int chessCol = 0;
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            int[] rows = chessArr[i];
            if (chessCol == 0) {
                chessCol = rows.length;
            }
            for (int j = 0; j < rows.length; j++) {
                int chess = rows[j];
                if (chess == 0) {
                    continue;
                }
                count++;
                sparseArr[count][0] = i;
                sparseArr[count][1] = j;
                sparseArr[count][2] = chess;
            }
        }
        sparseArr[0][0] = chessRow;
        sparseArr[0][1] = chessCol;
        sparseArr[0][2] = sum;
        return sparseArr;
    }
    /* 1.  */
    private static int[][] sparseToChess(int[][] sparseArr) {
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            int[] rows = sparseArr[i];
            chessArr[rows[0]][rows[1]] = rows[2];
        }
        return chessArr;
    }

    public static void printChessArray(int[][] chessArr) {
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%-2d\t", data);
            }
            System.out.println(" ");
        }
    }
}
