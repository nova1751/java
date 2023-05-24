package AlgorithmExp.Exp2;

public class Test3 {
    public static void main(String[] args) {
        int n = 5;
        int[][] arrayA = { { 7, 9, 3, 4, 8 }, { 8, 5, 6, 4, 5 } };
        int[][] arrayT = { { 2, 3, 1, 3 }, { 2, 1, 2, 2 } };
        int[] E = { 2, 4 };
        int[] X = { 3, 6 };
        int[][] result = new int[2][5];
        int[][] listNum = new int[2][4];
        int resultFinal, listFinal;

        result[0][0] = E[0] + arrayA[0][0];
        result[1][0] = E[1] + arrayA[1][0];
        for (int i = 1; i < n; i++) {
            if (result[0][i - 1] + arrayA[0][i] <= result[1][i - 1] + arrayT[1][i - 1] + arrayA[0][i]) {
                result[0][i] = result[0][i - 1] + arrayA[0][i];
                listNum[0][i - 1] = 1;
            } else {
                result[0][i] = result[1][i - 1] + arrayT[1][i - 1] + arrayA[0][i];
                listNum[0][i - 1] = 2;
            }

            if (result[1][i - 1] + arrayA[1][i] <= result[0][i - 1] + arrayT[0][i - 1] + arrayA[1][i]) {
                result[1][i] = result[1][i - 1] + arrayA[1][i];
                listNum[1][i - 1] = 2;
            } else {
                result[1][i] = result[0][i - 1] + arrayT[0][i - 1] + arrayA[1][i];
                listNum[1][i - 1] = 1;
            }
        }
        if (result[0][n - 1] + X[0] <= result[1][n - 1] + X[1]) {
            resultFinal = result[0][n - 1] + X[0];
            listFinal = 1;
        } else {
            resultFinal = result[1][n - 1] + X[1];
            listFinal = 2;
        }

        System.out.println("resultFinal: " + resultFinal);
        System.out.println("listFinal: " + listFinal);
    }
}
