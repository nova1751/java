package DataStructure.SortAlgorithm;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class RadixSort {
    public void processDemo() {
        int[] arr = { 53, 3, 542, 748, 14, 214 };
        System.out.println("原始数组:" + Arrays.toString(arr));
        processRadixSort(arr);
    }

    public void processRadixSort(int[] arr) {
        int[][] buckets = new int[10][arr.length];
        int[] bucketCounts = new int[buckets.length];
        // 比较个位数
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] % 10;
            buckets[temp][bucketCounts[temp]] = arr[i];
            bucketCounts[temp]++;
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (bucketCounts[i] == 0) {
                continue;
            }
            for (int j = 0; j < bucketCounts[i]; j++) {
                arr[index++] = buckets[i][j];
            }
            bucketCounts[i] = 0;
        }
        System.out.println("第一轮排序后:" + Arrays.toString(arr));

        // 比较十位数
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] / 10 % 10;
            buckets[temp][bucketCounts[temp]] = arr[i];
            bucketCounts[temp]++;
        }
        index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (bucketCounts[i] == 0) {
                continue;
            }
            for (int j = 0; j < bucketCounts[i]; j++) {
                arr[index++] = buckets[i][j];
            }
            bucketCounts[i] = 0;
        }
        System.out.println("第二轮排序后：" + Arrays.toString(arr));

        // 第 3 轮：比较百位数
        for (int i = 0; i < arr.length; i++) {
            // 获取到十位数
            int temp = arr[i] / 100 % 10;
            buckets[temp][bucketCounts[temp]] = arr[i];
            bucketCounts[temp]++;
        }
        index = 0; // 标识当前放回原数组的哪一个了
        for (int i = 0; i < buckets.length; i++) {
            if (bucketCounts[i] == 0) {
                continue;
            }
            for (int j = 0; j < bucketCounts[i]; j++) {
                arr[index++] = buckets[i][j];
            }
            bucketCounts[i] = 0;
        }
        System.out.println("第三轮排序后：" + Arrays.toString(arr));
    }

    public void radixSortTest() {
        int arr[] = { 53, 3, 542, 748, 14, 214 };
        System.out.println("原始数组：" + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    // 对于此函数的书写主要分为两个模块
    // 1. 获取最大的位数
    // 2. 注意好循环的处理
    public void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 获取最大数字的位数
        int maxLength = (max + "").length();
        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {
            int[][] buckets = new int[10][arr.length];
            int[] bucketCounts = new int[buckets.length];
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i] / n % 10;
                buckets[temp][bucketCounts[temp]] = arr[i];
                bucketCounts[temp]++;
            }
            int index = 0;
            for (int i = 0; i < buckets.length; i++) {
                if (bucketCounts[i] == 0) {
                    continue;
                }
                for (int j = 0; j < bucketCounts[i]; j++) {
                    arr[index++] = buckets[i][j];
                }
                bucketCounts[i] = 0;
            }
            // System.out.println("第" + m + "轮排序后" + Arrays.toString(arr));
        }
    }
    public void bulkDataSort() {
        int max = 80_000;
//        max = 8;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80_000);
        }
        if (arr.length < 10) {
            System.out.println("原始数组：" + Arrays.toString(arr));
        }
        Instant startTime = Instant.now();
        radixSort(arr);
        if (arr.length < 10) {
            System.out.println("排序后：" + Arrays.toString(arr));
        }
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        // radixSort.processDemo();
        // radixSort.radixSortTest();
        radixSort.bulkDataSort();
    }
}
