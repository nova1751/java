package DataStructure.ClassicAlgorithm;

public class HanoiTower {
    public void hanoiTower(int num, char a, char b, char c) {
        // 当只有一个盘的时:直接从 a -> c
        if (num == 1) {
            System.out.printf("第 %d 个盘从 %s -> %s \n", num, a, c);
        } else {
            // 否则，始终看成只有两个盘
            // 1. 最上面的盘：a->b,中间会用到c
            // 因为最小规模只有一个盘的时候，直接移动到c
            hanoiTower(num - 1, a, c, b);
            // 2. 最下面的盘：a->c
            System.out.printf("第 %d 个盘从 %s -> %s \n", num, a, c);
            // 3. 把b塔所有的盘移动到c:移动的过程中使用到a
            hanoiTower(num - 1, b, a, c);
        }
    }

    public void test() {
        hanoiTower(1, 'A', 'B', 'C');
        System.out.println();
        hanoiTower(3, 'A', 'B', 'C');
        System.out.println();
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.test();
    }
}
