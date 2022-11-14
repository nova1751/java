package DataStructure.SortAlgorithm;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class QuickSort {
    public void processDemo() {
        int[] arr = { -9, 78, 0, 23, -567, 70 };
        System.out.println("原始数组：" + Arrays.toString(arr));
        processQuickSort(arr, 0, arr.length - 1);
    }

    public void processQuickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 解决循环无法跳出的问题
            if (arr[l] == pivot) {
                // 不移动自身可以保证基准值不会改变
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        System.out.println("第 1 轮排序后：" + Arrays.toString(arr));
    }

    public void quickSortTest() {
        int arr[] = { -9, 78, 0, 23, -567, 70 };
        // int arr[] = {-9, 78, 0, -23, 0, 70}; // 在推导过程中，将会导致交换异常的数组，在这里不会出现那种情况
        int left = 0;
        int right = arr.length - 1;
        System.out.println("原始数组：" + Arrays.toString(arr));
        quickSort(arr, left, right);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }

    }

    public void bulkDataSort() {
        int max = 80_000;
        // int max = 8;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * 80_000);
        }
        if (arr.length < 10) {
            System.out.println("原始数组：" + Arrays.toString(arr));
        }
        Instant startTime = Instant.now();
        // processQuickSort(arr, 0, arr.length - 1); // 和老师的原版代码对比，结果是一样的
        quickSort(arr, 0, arr.length - 1);
        if (arr.length < 10) {
            System.out.println("排序后：" + Arrays.toString(arr));
        }
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        // quickSort.processDemo();
        quickSort.bulkDataSort();
    }
}
