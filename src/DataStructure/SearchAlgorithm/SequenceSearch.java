package DataStructure.SearchAlgorithm;

public class SequenceSearch {
    public void seqSearchTest() {
        int[] arr = { 1, 8, 10, 89, 1000, 1234 };
        int i = seqSearch(arr, 1000);
        System.out.println("查找目标值1000：" + (i == -1 ? "未找到" : "已找到" + "下标为:" + i));
        i = seqSearch(arr, -990);
        System.out.println("查找目标值-990：" + (i == -1 ? "未找到" : "已找到" + "下标为：" + i));
    }

    public int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequenceSearch sequenceSearch = new SequenceSearch();
        sequenceSearch.seqSearchTest();
    }
}
