package DataStructure.Stack;

import org.junit.Test;

public class LinkedListStackTest {
    @Test
    public void pushTest() {
        LinkedListStack stack = new LinkedListStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        stack.push(5);
    }

    @Test
    public void popTest() {
        LinkedListStack stack = new LinkedListStack(4);
        stack.push(1);
        stack.push(2);
        stack.print();
        System.out.println("pop data:" + stack.pop());
        stack.print();
        System.out.println("pop data:" + stack.pop());
        stack.print();
    }
}
