package DataStructure.DoubleLinkedListPackage;

import org.junit.Before;
import org.junit.Test;

/**
 * 双向链表测试
 */
public class DoubleLinkedListTest {
    DoubleLinkedList doubleLinkedList;

    @Before
    public void before() {
        HeroNode hero1 = new HeroNode(1, "Amamiya Ren", "Joker");
        HeroNode hero2 = new HeroNode(2, "Ryuji Sakamoto", "Skull");
        HeroNode hero3 = new HeroNode(3, "Anne Takamaki", "Panther");
        HeroNode hero4 = new HeroNode(4, "Yusuke Kitagawa", "Fox");

        // 测试新增
        doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
    }

    @Test
    public void addTest() {
        // before 中已测试
    }

    /**
     * 更新测试
     */
    @Test
    public void updateTest() {
        System.out.println("Before update:");
        doubleLinkedList.print();
        HeroNode hero4New = new HeroNode(4, "Yusuke Kitagawa-Test", "Fox-Test");
        doubleLinkedList.update(hero4New);
        System.out.println("After update:");
        doubleLinkedList.print();
    }

    /**
     * 删除测试
     */
    @Test
    public void deleteTest() {
        System.out.println("Before deletion:");
        doubleLinkedList.print();
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(4);
        doubleLinkedList.delete(3);
        System.out.println("After deletion:");
        doubleLinkedList.print();
    }
    @Test
    public void addByOrderTest() {
        HeroNode hero1 = new HeroNode(1, "Amamiya Ren", "Joker");
        HeroNode hero2 = new HeroNode(2, "Ryuji Sakamoto", "Skull");
        HeroNode hero3 = new HeroNode(3, "Anne Takamaki", "Panther");
        HeroNode hero4 = new HeroNode(4, "Yusuke Kitagawa", "Fox");

        // 测试新增
        doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.print();

    }
}
