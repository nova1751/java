package DataStructure;

import java.util.Scanner;

public class CircleQueueDemo {
    // 写一个主函数内部写一个控制台输入的小程序
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        System.out.println("s(show): 显示队列");
        System.out.println("e(exit): 退出程序");
        System.out.println("a(add): 添加数据到队列");
        System.out.println("g(get): 从队列取出数据");
        System.out.println("h(head): 查看队列头的数据");
        System.out.println("t(tail): 查看队列尾的数据");
        System.out.println("p(isEmpty): 队列是否为空");
        while (loop) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入要添加到队列中的整数：");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    try {
                        int res = queue.get();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.head();
                        System.out.println("队头数据为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':
                    try {
                        int res = queue.tail();
                        System.out.println("队尾数据为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    System.out.printf("队列是否为空：%s", queue.isEmpty());
                    break;
            }
        }
    }
}

// 开始编写环形队列这个类
class CircleQueue {
    // 使用私有变量储存四个基本属性
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    // 初始化环形队列
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize + 1; // 此处+1是因为需要给rear留出空的储存空间
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    // 取出队列的数据
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 往队列中储存数据
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 显示队列中的数据
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            int index = i % maxSize;
            System.out.printf("arr[%d] = %d\n", index, arr[index]);
        }
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }

    public int tail() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return rear - 1 < 0 ? arr[maxSize - 1] : arr[rear - 1];
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}