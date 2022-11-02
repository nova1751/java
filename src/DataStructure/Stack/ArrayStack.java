package DataStructure.Stack;

public class ArrayStack {
    // 定义三个基本属性，堆栈，堆栈的大小，栈顶元素
    int[] stack;
    int maxSize;
    int top = -1;

    // 构造函数书写
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 判断堆栈是否已满，判断top是否到了最后一个元素
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 判断堆栈是否为空，即判断top的值是否等于-1
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈函数书写，先判断是否为满再入栈
    public void push(int element) {
        if (isFull()) {
            System.out.println("堆栈已满！");
            return;
        }
        stack[++top] = element;
    }

    // 出栈函数书写，先判断是否为空再出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        return stack[top--];
    }

    // 打印栈中元素
    public void print() {
        if (isEmpty()) {
            System.out.println("栈中无数据！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("index=%d value=%d \n", i, stack[i]);
        }
    }

    // 添加显示栈顶元素的方法
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return stack[top];
    }
}
