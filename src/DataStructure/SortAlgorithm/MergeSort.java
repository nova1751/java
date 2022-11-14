package DataStructure.SortAlgorithm;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class MergeSort {
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left; // 左边有序数组的初始索引
        int r = mid + 1; // 右边有序数组的初始索引
        int t = 0; // temp数组中当前最后一个有效数据的索引

        // 因为是合并两个数组,所以需要两边的数组都还有值的时候才需要合并
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                l++;
                t++;
            } else {
                temp[t] = arr[r];
                r++;
                t++;
            }
        }

        while (l <= mid) {
            temp[t] = arr[l];
            l++;
            t++;
        }

        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }

        int tempL = left;
        t = 0;

        System.out.println("tempL=" + tempL + ";right=" + right);
        while (tempL <= right) {
            arr[tempL] = temp[t];
            t++;
            tempL++;
        }
    }

    public void sortTest() {
        int[] arr = new int[] { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    public void myMergeSortTest() {
        int[] arr = new int[] { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] temp = new int[arr.length];
        myMergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public void myMergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            myMergeSort(arr, left, mid, temp);
            myMergeSort(arr, mid + 1, right, temp);

            myMerge(arr, left, mid, right, temp);
        }
    }

    public void myMerge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }

        t = 0;
        int tempL = left;
        // System.out.println("tempL=" + tempL + "; right=" + right);
        while (tempL <= right) {
            arr[tempL++] = temp[t++];
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
        int[] temp = new int[arr.length];
        myMergeSort(arr, 0, arr.length - 1, temp);
        if (arr.length < 10) {
            System.out.println("排序后：" + Arrays.toString(arr));
        }
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        // mergeSort.myMergeSortTest();
        mergeSort.bulkDataSort();
    }
}
