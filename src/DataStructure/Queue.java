package DataStructure;

public class Queue {
    /*
     * 主函数：
     * 添加队列元素与展示队列元素
     */
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("查看队列中的数据：");
        queue.show();
        System.out.println("查看队列头数据：" + queue.head());
        System.out.println("查看队列尾数据：" + queue.tail());
        System.out.println("获取队列的数据：" + queue.get());
        System.out.println("查看队列中的数据：");
        queue.show();
    }
}

class ArrayQueue {
    // 确定队列的4个基本属性,使用private修饰符修饰成员变量
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];

    // 创建队列，初始化成员变量,使用构造函数创建
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // 取出队列的数据,同时使用isEmpty来判断队列是否为空
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[++front];
    }

    // 往队列中放入数据，用isFull来判断队列是否已满
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满！");
            return;
        }
        arr[++rear] = n;
    }

    // 显示队列中的数据,判断不为空之后采用循环遍历的方式显示数据
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]: %d\n", i, arr[i]);
        }
    }

    // 取出队头元素
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

    // 取出队尾元素
    public int tail() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[rear];
    }

    private boolean isFull() {
        return rear == maxSize - 1;
    }

    private boolean isEmpty() {
        return rear == front;
    }

}
