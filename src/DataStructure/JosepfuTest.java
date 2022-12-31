package DataStructure;

import org.junit.Test;

public class JosepfuTest {
    @Test
    public void addTest() {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.print();
    }

    @Test
    public void countBoy() {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        System.out.println("Build Circle Queue:");
        circleSingleLinkedList.print();

        // 开始玩游戏
        // 正确的输出顺序为：2、4、1、5、3
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}
