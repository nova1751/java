package DataStructure.SearchAlgorithm;

public class InsertValueSearch {
    public void insertValueTest() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int findVal = 1;
        int result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 50;
        result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 100;
        result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));
    }

    public int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("InsertValueSearch");
        // 由于mid由值确定，故需要进行边界判定，否则会导致越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]); // 需要考虑运算符的运算顺序
        int midVal = arr[mid];

        if (findVal == midVal) {
            return mid;
        }
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        }
        return insertValueSearch(arr, left, mid - 1, findVal);
    }

    public void insertValueTest2() {
        int[] arr = new int[] { 1, 8, 10, 89, 1000, 1000, 1234, 1234 };

        int findVal = 1;
        int result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 1000;
        result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 1234;
        result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 12345;
        result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));

        findVal = 89;
        result = insertValueSearch(arr, 0, arr.length - 1, findVal);
        System.out.println("查找值 " + findVal + "：" + (result == -1 ? "未找到" : "找到值，索引为：" + result));
    }

    public static void main(String[] args) {
        InsertValueSearch insertValueSearch = new InsertValueSearch();
        insertValueSearch.insertValueTest();
        // insertValueSearch.insertValueTest2();
    }
}
