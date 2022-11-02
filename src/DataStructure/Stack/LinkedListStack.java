package DataStructure.Stack;


public class LinkedListStack {
    // 构造三个基本属性
    int maxSize; // 栈中最多的元素
    int size; // 栈中现在具有的元素
    Node top; // 栈顶的元素

    // 构造函数
    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    // 判断栈是否为满的元素
    public boolean isFull() {
        return size == maxSize;
    }

    // 判断栈是否为空的元素
    public boolean isEmpty() {
        return size == 0;
    }

    // 入栈函数，先判断是否为满，再将元素添加到链表的表头
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满！");
            return;
        }
        // 储存top元素
        Node temp = top;
        // 更新top节点
        top = new Node(value);
        // 指向前一top节点
        top.next = temp;
        // 储存元素个数自增
        size++;
    }

    // 出栈函数书写
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空！");
        }
        Node temp = top;
        top = top.next; // 注意已经存在的变量加上int会新创建变量
        size--;
        return temp.value;
    }

    // 显示栈中的元素
    public void print() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        Node cur = top;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}

class Node {
    // 定义节点的两个基本属性
    int value;
    Node next;

    // 书写构造函数
    public Node(int value) {
        this.value = value;
    }

    // 重写toString函数
    @Override
    public String toString() {
        return "Node{" + "value=" + '}';
    }
}
