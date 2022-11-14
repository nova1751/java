package DataStructure.SortAlgorithm;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ShellSort {
    // 测试函数
    public void processDemo() {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        System.out.println("原始数组：" + Arrays.toString(arr));
        processShellSort(arr);
    }

    // 希尔排序函数
    public void processShellSort(int[] arr) {
        // 函数基本思想为：交换
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮排序后的结果:" + Arrays.toString(arr));
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第二轮排序后的结果:" + Arrays.toString(arr));

        // 第 3 轮：上一轮排序后的数组：[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
        // 将 10 个数字分成了 1 组（上一次的增量 2 / 2），增量也为 1，需要对 1 组进行排序
        for (int i = 1; i < arr.length; i++) {
            // 第 1 组：[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
            // i = 1 ：j = 0, j-=1 = 0 - 1 = -1，跳出循环
            // 0 为有序列表中的最后一个元素，2 为无须列表中要比较的元素。 0 < 2,不交换
            // [0, 2 有序 <-> 无序, 1, 4, 3, 5, 7, 6, 9, 8]
            // i = 2 ：j = 1, j-=1 = 1 - 1 = o
            // 2 为有序列表中的最后一个元素，1 为无序列表中要比较的元素， 2 > 1,交换
            // 交换后：[0, 1, 2, 4, 3, 5, 7, 6, 9, 8]
            // 由于不退出循环，还要比较有序列表中的数据，0 与 1
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第 3 轮排序后：" + Arrays.toString(arr));

    }

    public void shellSortTest() {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        System.out.println("原始数组：" + Arrays.toString(arr));
        shellSort(arr);
    }

    public void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
                // System.out.println("第" + i + "次排序的结果为" + Arrays.toString(arr));
            }
        }
    }

    public void bulkDataSort() {
        int max = 80_000;
        // int max = 8;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80_000);
        }

        Instant startTime = Instant.now();
        moveShellSort(arr);
        // shellSort(arr);
        // System.out.println(Arrays.toString(arr));
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    public void moveShellSortTest() {
        int arr[] = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        System.out.println("原始数组：" + Arrays.toString(arr));
        moveShellSort(arr);
    }

    public void moveShellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int currentIndexValue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && currentIndexValue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = currentIndexValue;
            }
            // System.out.println("增量为 " + gap + " 的这一轮排序后：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.bulkDataSort();
        // shellSort.moveShellSortTest();
    }

}
