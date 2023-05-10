package AlgorithmExp.Exp1;

import java.util.Arrays;
import java.util.Comparator;

// 定义一个Point类，表示二维空间中的一个点
class Point {
    double x; // x坐标
    double y; // y坐标

    // 构造方法
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 计算两个点之间的欧几里得距离
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    // 重写toString方法，方便输出
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// 定义一个比较器类，按照x坐标升序排序
class XComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        return Double.compare(p1.x, p2.x);
    }
}

// 定义一个比较器类，按照y坐标升序排序
class YComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        return Double.compare(p1.y, p2.y);
    }
}

// 定义一个主类，实现最近点对分治算法
public class Test2 {
    // 定义一个静态方法，返回给定点集中的最近点对和距离，使用暴力求解
    public static Object[] bruteForce(Point[] points) {
        // 如果点集为空或只有一个点，返回空数组和无穷大距离
        if (points == null || points.length <= 1) {
            return new Object[] { new Point[0], Double.POSITIVE_INFINITY };
        }
        // 如果点集只有两个点，返回这两个点和它们的距离
        if (points.length == 2) {
            return new Object[] { points, points[0].distance(points[1]) };
        }
        // 初始化最小距离和对应的点对
        double minDist = Double.POSITIVE_INFINITY;
        Point[] minPair = new Point[2];
        // 遍历所有的点对，计算它们的距离，并更新最小距离和点对
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = points[i].distance(points[j]);
                if (dist < minDist) {
                    minDist = dist;
                    minPair[0] = points[i];
                    minPair[1] = points[j];
                }
            }
        }
        // 返回最终的结果
        return new Object[] { minPair, minDist };
    }

    // 定义一个静态方法，返回给定点集中的最近点对和距离
    public static Object[] closestPair(Point[] points) {
        // 如果点集为空或只有一个点，返回空数组和无穷大距离
        if (points == null || points.length <= 1) {
            return new Object[] { new Point[0], Double.POSITIVE_INFINITY };
        }
        // 如果点集只有两个点，返回这两个点和它们的距离
        if (points.length == 2) {
            return new Object[] { points, points[0].distance(points[1]) };
        }
        // 将点集按照x坐标升序排序
        Arrays.sort(points, new XComparator());
        // 找到中间的x值
        int mid = points.length / 2;
        double midX = points[mid].x;
        // 将点集分为左右两部分
        Point[] left = Arrays.copyOfRange(points, 0, mid);
        Point[] right = Arrays.copyOfRange(points, mid, points.length);
        // 递归地在左右两部分中寻找最近点对和距离
        Object[] leftResult = closestPair(left);
        Object[] rightResult = closestPair(right);

        // 比较左右两部分的结果，取较小的距离和对应的点对
        double minDist;
        Point[] minPair;
        if ((double) leftResult[1] < (double) rightResult[1]) {
            minDist = (double) leftResult[1];
            minPair = (Point[]) leftResult[0];
        } else {
            minDist = (double) rightResult[1];
            minPair = (Point[]) rightResult[0];
        }
        // 考虑最近点对可能跨越左右两部分的情况
        // 创建一个临时数组，存放距离中间值不超过最小距离的点
        Point[] temp = new Point[points.length];
        int count = 0;
        for (Point p : points) {
            if (Math.abs(p.x - midX) <= minDist) {
                temp[count++] = p;
            }
        }
        // 将临时数组按照y坐标升序排序
        Arrays.sort(temp, 0, count, new YComparator());
        // 遍历临时数组中的每个点，检查它的上下范围内是否有更近的点对
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count && temp[j].y - temp[i].y <= minDist; j++) {
                double dist = temp[i].distance(temp[j]);
                if (dist < minDist) {
                    minDist = dist;
                    minPair = new Point[] { temp[i], temp[j] };
                }
            }
        }
        // 返回最终的结果
        return new Object[] { minPair, minDist };
    }

    // 定义一个测试方法，随机生成一些点，并输出最近点对和距离
    public static void test(int n) {
        // 创建一个点数组，存放随机生成的点
        Point[] points = new Point[n];
        // 用一个随机数生成器，生成0到100之间的随机数作为坐标
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble() * 100;
            double y = random.nextDouble() * 100;
            points[i] = new Point(x, y);
        }
        // 输出生成的点
        System.out.println("生成的" + n + "个点为：");
        for (Point p : points) {
            System.out.println(p);
        }
        // 调用分治算法，得到结果
        long startTime1 = System.currentTimeMillis(); // 记录开始时间
        Object[] result1 = closestPair(points);
        long endTime1 = System.currentTimeMillis(); // 记录结束时间
        long time1 = endTime1 - startTime1; // 计算运行时间
        // 输出结果
        System.out.println("分治算法得到的最近点对为：");
        for (Point p : (Point[]) result1[0]) {
            System.out.println(p);
        }
        System.out.println("最近距离为：" + result1[1]);
        System.out.println("运行时间为：" + time1 + "毫秒");

        // 调用暴力算法，得到结果
        long startTime2 = System.currentTimeMillis(); // 记录开始时间
        Object[] result2 = bruteForce(points);
        long endTime2 = System.currentTimeMillis(); // 记录结束时间
        long time2 = endTime2 - startTime2; // 计算运行时间
        // 输出结果
        System.out.println("暴力算法得到的最近点对为：");
        for (Point p : (Point[]) result2[0]) {
            System.out.println(p);
        }
        System.out.println("最近距离为：" + result2[1]);
        System.out.println("运行时间为：" + time2 + "毫秒");

        // 比较两种算法的结果是否一致
        if (result1[1].equals(result2[1])) {
            System.out.println("两种算法得到的结果一致");
        } else {
            System.out.println("两种算法得到的结果不一致");
        }
    }

    // 主方法，调用测试方法
    public static void main(String[] args) {
        test(10); // 随机生成10个点进行测试
    }
}