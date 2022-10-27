
public class App {
    /*
     * 1. 创建初始二维数组并打印
     * 2. 将二维数组转化为稀疏数组并打印
     * 3. 将稀疏数组转化为二维数组并打印
     */
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[0][1] = 1;
        chessArr[1][2] = 2;
        chessArr[2][3] = 3;
        chessArr[6][6] = 6;
        System.out.println("初始数组为：");
        printChessArray(chessArr);

        int[][] sparseArr = chessToSparse(chessArr);
        System.out.println("稀疏数组为：");
        printChessArray(sparseArr);

        int[][] chessArr2 = sparseToChess(sparseArr);
        System.out.println("原来的二维数组：");
        printChessArray(chessArr2);
    }

    /*
     * 1. 记录有效数字的个数sum
     * 2，创建稀疏数组int[sum+1][3]
     * 3. 记录chessRow,chessCol以及稀疏数组下标count
     * 4. 遍历二维数组，填充稀疏数组的值
     * 5. 返回稀疏数组
     */
    private static int[][] chessToSparse(int[][] chessArr) {
        int sum = 0;
        for (int[] rows : chessArr) {
            for (int chess : rows) {
                if (chess != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArr = new int[sum + 1][3];
        int chessRow = chessArr.length;
        int chessCol = chessArr[0].length;
        int count = 0;
        for (int i = 0; i < chessRow; i++) {
            for (int j = 0; j < chessCol; j++) {
                if (chessArr[i][j] == 0) {
                    continue;
                }
                count++;
                sparseArr[count][0] = i;
                sparseArr[count][1] = j;
                sparseArr[count][2] = chessArr[i][j];
            }
        }
        sparseArr[0][0] = chessRow;
        sparseArr[0][1] = chessCol;
        sparseArr[0][2] = count;
        return sparseArr;
    }

    /*
     * 1. 读取稀疏数组第一行，创建原来的二维数组
     * 2. 将稀疏数组中的有效元素还原
     * 3. 返回转化后的二维数组
     */
    private static int[][] sparseToChess(int[][] sparseArr) {
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            int[] rows = sparseArr[i];
            chessArr[rows[0]][rows[1]] = rows[2];
        }
        return chessArr;
    }

    /*
     * 通过两个for循环循环输出矩阵的值
     */
    public static void printChessArray(int[][] chessArr) {
        for (int[] rows : chessArr) {
            for (int chess : rows) {
                System.out.printf("%-2d\t", chess);
            }
            System.out.println("");
        }
    }
}