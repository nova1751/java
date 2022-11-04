package DataStructure.SortAlgorithm;

import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        // bubbleSort.processDemo3();
        // bubbleSort.bubbleSortTest();
        bubbleSort.bulkDataSort();
    }

    public void processDemo() {
        int[] arr = { 3, 9, -1, 10, -2 };
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第 1 趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第 2 趟排序：将第 2 大的数排在倒数第 2 位
        // 总共排序：arr.length - 1 - 1 ；
        // 从头开始排序，其他没有变化，只是将排序次数减少了一次
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第 2 趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第 3 趟排序：将第 3 大的数排在倒数第 3 位
        // 总共排序：arr.length - 1 - 2 ；
        // 从头开始排序，其他没有变化，只是将排序次数减少了 2 次
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第 3 趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第 4 趟排序：将第 4 大的数排在倒数第 4 位
        // 总共排序：arr.length - 1 - 3 ；
        // 从头开始排序，其他没有变化，只是将排序次数减少了 3 次
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第 4 趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第 5 趟没有必要，因为这里有 5 个数字，确定了 4 个数字，剩下的那一个就已经出来了
    }

    public void processDemo2() {
        int[] arr = { 3, 9, -1, 10, -2 };
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) { // 注意i月j使用的场合需要分清楚
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第 " + (i + 1) + " 趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }

    public void processDemo3() {
        int[] arr = { 3, 9, -1, 10, -2 };
        int temp = 0;
        boolean change = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) { // 注意i月j使用的场合需要分清楚
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
            System.out.println("第 " + (i + 1) + " 趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 把排序算法封装成一个方法，方便被复用
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 总共排序：arr.length - 1
        int temp = 0; // 临时变量，交换的时候使用
        boolean change = false;
        for (int j = 0; j < arr.length - 1; j++) {
            change = false;
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                // 如果 1 轮下来，都没有进行排序，则可以提前退出
                break;
            }
        }
    }

    public void bubbleSortTest() {
        int[] arr = { 3, 9, -1, 10, 20 };
        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public void bulkDataSort() {
        int max = 80_000;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80_000);
        }

        Instant startTime = Instant.now();
        bubbleSort(arr);
        // System.out.println(Arrays.toString(arr));
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }
}
