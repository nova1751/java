package DataStructure.SearchAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public void binaryTest() {
        int[] arr = new int[] { 1, 8, 10, 89, 1000, 1234 };
        int findVal = 89;
        int result = binary(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值：" + findVal + ":" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = -1;
        result = binary(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 123456;
        result = binary(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 1;
        result = binary(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));
    }

    private int binary(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (midVal == findVal) {
            return mid;
        }
        if (midVal > findVal) {
            return binary(arr, left, mid - 1, findVal);
        }
        return binary(arr, mid + 1, right, findVal);
    }

    public void binarySearch2() {
        int[] arr = new int[] { 1, 8, 10, 89, 1000, 1000, 1234 };
        int findVal = 89;
        List<Integer> result = binary2(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == null ? "未找到" : "已找到，索引值为：" + result));

        findVal = -1;
        result = binary2(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == null ? "未找到" : "找到值，索引为：" + result));

        findVal = 123456;
        result = binary2(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == null ? "未找到" : "找到值，索引为：" + result));

        findVal = 1;
        result = binary2(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == null ? "未找到" : "找到值，索引为：" + result));

        findVal = 1000;
        result = binary2(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == null ? "未找到" : "找到值，索引为：" + result));
    }

    private List<Integer> binary2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal == findVal) {
            List<Integer> indexArr = new ArrayList<>();
            indexArr.add(mid);
            int tempIndex = mid - 1;
            while (true) {
                if (tempIndex < 0 || arr[tempIndex] != midVal) {
                    break;
                }
                indexArr.add(tempIndex);
                tempIndex--;
            }
            tempIndex = mid + 1;
            while (true) {
                if (tempIndex >= arr.length || arr[tempIndex] != midVal) {
                    break;
                }
                indexArr.add(tempIndex);
                tempIndex++;
            }
            return indexArr;
        }
        if (midVal > findVal) {
            return binary2(arr, left, mid - 1, findVal);
        }
        return binary2(arr, mid + 1, right, findVal);
    }
    public static void main(String[] args) {
        BinarySearch binarySearch=new BinarySearch();
        // binarySearch.binaryTest();
        binarySearch.binarySearch2();
    }
}
