package DataStructure.Stack;

import java.lang.reflect.Array;

public class Calculator {
    // 创建数据栈与符号栈
    ArrayStack numStack = new ArrayStack(10); // 数组栈
    ArrayStack operStack = new ArrayStack(10); // 符号栈

    public static void main(String[] args) {
        String expression = "3+2*6-2";
        // 创建Calculator对象
        Calculator calculator = new Calculator();
        // 扫描表达式
        calculator.scan(expression);
        // 剩余数据进行计算
        int res = calculator.nextCal();
        System.out.printf("%s = %d", expression, res);
    }
}
