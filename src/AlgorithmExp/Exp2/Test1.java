package AlgorithmExp.Exp2;

import java.util.Arrays;

public class Test1 {
    public static int[][] schedule(int[] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs); // 按作业时长升序排序

        int[][] dp = new int[n + 1][n + 1]; // dp数组用于存储子问题的最优解

        // 计算dp数组的值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (jobs[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - jobs[i - 1]] + jobs[i - 1]);
                }
            }
        }

        int maxTime = dp[n][n];
        int[] schedule = new int[n]; // 用于存储作业的排程结果
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                schedule[i - 1] = jobs[i - 1];
                j -= jobs[i - 1];
            }
            i--;
        }

        return new int[][] { schedule, { maxTime } };
    }

    public static void main(String[] args) {
        int[] jobs = { 3, 1, 4, 2, 8, 5 }; // 示例输入

        int[][] result = schedule(jobs);
        int[] schedule = result[0];
        int maxTime = result[1][0];

        System.out.println("作业排程结果：");
        for (int i = 0; i < schedule.length; i++) {
            System.out.println("Job " + (i + 1) + ": " + schedule[i]);
        }
        System.out.println("最优解：" + maxTime);
    }
}
