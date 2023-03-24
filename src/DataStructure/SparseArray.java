package DataStructure;

public class SparseArray {
    // 主函数：负责初始化原始二维数组，同时测试原始二维数组与稀疏数组的互相转换
    public static void main(String[] args) {
        // 1. 创建原始数组并初始化
        int[][] chessArray = new int[8][9];
        chessArray[3][5] = 1;
        chessArray[4][0] = 2;
        chessArray[5][7] = 3;
        chessArray[7][7] = 3;
        // 2. 打印原始二维数组
        System.out.println("Raw array preview:");
        printArray(chessArray);
        // 3. 原始二维数组转稀疏数组
        int[][] sparseArray = chessToSparse(chessArray);
        // 4. 打印稀疏数组
        System.out.println("chessArray to sparseArray:");
        printArray(sparseArray);
        // 稀疏数组转二维数组
        chessArray = sparseToChess(sparseArray);
        // 打印转换回来的稀疏数组
        System.out.println("chessArray to sparseArray:");
        printArray(chessArray);
    }

    // 书写二维数组打印函数
    private static void printArray(int[][] arr) {
        // 采用两个增强for循环配合system.out.printf格式化输出二维数组
        for (int[] row : arr) {
            for (int col : row) {
                System.out.printf("%-2d ", col);
            }
            // 换行
            System.out.println();
        }
    }

    // 书写原始数组转稀疏数组的函数
    private static int[][] chessToSparse(int[][] arr) {
        // 确定稀疏数组的有效数字个数，即sum的值
        int sum = 0;
        for (int[] row : arr) {
            for (int col : row) {
                if (col != 0) {
                    sum++;
                }
            }
        }
        // 初始化稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 完成稀疏数字第一行的填充
        sparseArray[0][0] = arr.length;
        sparseArray[0][1] = arr[0].length;
        sparseArray[0][2] = sum;
        // 通过两层for循环遍历有效数字，填充稀疏数组剩余值
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = arr[i][j];
                    index++;
                }
            }
        }
        return sparseArray;
    }

    // 编写稀疏数组转二维数组的函数
    private static int[][] sparseToChess(int[][] arr) {
        // 创建二维数组
        int[][] chessArray = new int[arr[0][0]][arr[0][1]];
        // 采用for循环给稀疏数组赋值
        for (int i = 1; i < arr.length; i++) {
            chessArray[arr[i][0]][arr[i][1]] = arr[i][2];
        }
        return chessArray;
    }
}
