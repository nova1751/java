package AlgorithmExp.Exp2;

public class Test4 {
    public static void main(String[] args) {
        int[][] arrayA = { { 7, 9, 3, 4, 8 }, { 8, 5, 6, 4, 5 } };
        int[][] arrayT = { { 2, 3, 1, 3 }, { 2, 1, 2, 2 } };
        int[] E = { 2, 4 };
        int[] X = { 3, 6 };

        int numStations = arrayA[0].length;

        int[] T1 = new int[numStations]; // 存储从起始站点到当前站点的最小时间（第1条流水线）
        int[] T2 = new int[numStations]; // 存储从起始站点到当前站点的最小时间（第2条流水线）
        int[] path = new int[numStations]; // 存储最优路径

        // 初始化第一个站点的时间
        T1[0] = E[0] + arrayA[0][0];
        T2[0] = E[1] + arrayA[1][0];

        // 动态规划计算最小时间
        for (int i = 1; i < numStations; i++) {
            // 第1条流水线
            T1[i] = Math.min(T1[i - 1] + arrayA[0][i], T2[i - 1] + arrayT[1][i - 1] + arrayA[0][i]);
            // 第2条流水线
            T2[i] = Math.min(T2[i - 1] + arrayA[1][i], T1[i - 1] + arrayT[0][i - 1] + arrayA[1][i]);
        }

        // 计算最后一个站点到终点的最小时间，并确定最优路径
        int minTime = Math.min(T1[numStations - 1] + X[0], T2[numStations - 1] + X[1]);
        int lastLine = (T1[numStations - 1] + X[0] < T2[numStations - 1] + X[1]) ? 0 : 1;

        // 回溯确定最优路径
        path[numStations - 1] = lastLine;
        for (int i = numStations - 2; i >= 0; i--) {
            if (lastLine == 0) {
                lastLine = (T1[i] + arrayT[0][i] + arrayA[1][i + 1] <= T2[i] + arrayT[1][i] + arrayA[1][i + 1]) ? 0 : 1;
            } else {
                lastLine = (T2[i] + arrayT[1][i] + arrayA[0][i + 1] <= T1[i] + arrayT[0][i] + arrayA[0][i + 1]) ? 1 : 0;
            }
            path[i] = lastLine;
        }

        // 输出结果
        System.out.println("最小装配时间：" + minTime);
        System.out.print("装配方案：");
        for (int i = 0; i < numStations; i++) {
            System.out.print("Line " + (path[i] + 1) + " Station " + (i + 1) + ",");
        }
    }
}
