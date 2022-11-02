package DataStructure.Recursion;

public class App {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static int factorial2(int n) {
        if (n == 1) {
            return 1;
        } else {
            int factorial = factorial2(n - 1);
            // 按照递归调用原则，这里我们使用的是 n-1,返回条件是 n==1
            // 所以，当 n = 1 时，也就是 factorial = 1 时，这里的语句最最先开始执行
            // 然后把执行结果返回到上一个独立空间，并继续执行计算
            System.out.printf("%d * %d = %d \n", factorial, n, factorial * n);
            return factorial * n;
        }

    }
}
