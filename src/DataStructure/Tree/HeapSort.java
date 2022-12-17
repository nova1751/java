package DataStructure.Tree;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.junit.Test;

public class HeapSort {
    // 测试主函数
    public void sortTest() {
        // int[] arr = { 4, 6, 8, 5, 9 };
        // sort(arr);
        int[] arr2 = { 503, 87, 512, 61, 908, 170, 897, 275, 653, 426 };
        sort(arr2);
    }

    private void sort(int[] arr) {
        // 构造初始堆，从第一个非叶子节点开始调整

        // 循环调整
        // 从第一个非叶子节点开始调整，自低向上
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        // 循环交换构成排序数组
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeap(arr, 0, j);
            System.out.println(Arrays.toString(arr));
        }

    }

    // 编写调整堆的函数
    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    @Test
    public void bulkDataSort() {
        int max = 800_000;
        // int max = 8;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        if (arr.length < 10) {
            System.out.println("原始数组：" + Arrays.toString(arr));
        }
        Instant startTime = Instant.now();
        sort(arr);
        if (arr.length < 10) {
            System.out.println("排序后：" + Arrays.toString(arr));
        }
        Instant endTime = Instant.now();
        System.out.println("共耗时：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.sortTest();
        // heapSort.bulkDataSort();
    }
}
