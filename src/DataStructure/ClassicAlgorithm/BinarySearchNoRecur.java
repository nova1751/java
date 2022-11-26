package DataStructure.ClassicAlgorithm;

public class BinarySearchNoRecur {
    public void fun() {
        int[] arr = new int[] { 1, 3, 8, 10, 11, 67, 100 };
        int target = 1;
        int result = binarySearch(arr, target);
        System.out.printf("查找 %d ，找位置为 %d \n", target, result);

        target = 11;
        result = binarySearch(arr, target);
        System.out.printf("查找 %d ,找位置为 %d \n", target, result);

        target = 100;
        result = binarySearch(arr, target);
        System.out.printf("查找 %d ,找位置为 %d \n", target, result);

        target = -1;
        result = binarySearch(arr, target);
        System.out.printf("查找 %d ,找位置为 %d \n", target, result);

        target = 200;
        result = binarySearch(arr, target);
        System.out.printf("查找 %d ,找位置为 %d \n", target, result);
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid >= arr.length) {
                return -1;
            }
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchNoRecur binarySearchNoRecur=new BinarySearchNoRecur();
        binarySearchNoRecur.fun();
    }
}
