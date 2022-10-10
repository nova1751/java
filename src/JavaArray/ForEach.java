package JavaArray;

public class ForEach {
    public static void main(String[] args) {
        double[] mylist = { 1.9, 2.9, 3.4, 3.5 };
        for (double element : mylist) {
            System.out.println(element);
        }
        printArray(new int[] { 3, 1, 2, 6, 4, 2 });
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " "); //此处单引号与双引号的作用有着显著的区别
    }
}
