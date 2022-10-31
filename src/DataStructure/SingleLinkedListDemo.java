package DataStructure;

import java.util.Stack;
// 单向链表测试函数

public class SingleLinkedListDemo {
    // 创建4个节点并调用函数添加对象
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        // test2();
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();

    }

    public static void test2() {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addByOrder(hero4); // 添加顺序提前
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
    }
}

// 单向链表节点的书写
class SingleLinkedList {
    // 创建一个头节点
    private HeroNode head = new HeroNode(0, "", "");

    // 添加节点，将新加入的元素添加至链表的最后

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    // 打印链表中的数据
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 有序插入元素
    public void addByOrder(HeroNode node) {
        // 分为节点为空 大于 相等三种情况来书写函数
        HeroNode temp = head; // 此处temp为辅助变量存放在栈中，指向堆空间的head
        boolean exist = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            }
            if (temp.next.no == node.no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (exist) {
            System.out.printf("准备插入的英雄编号 %d 已经存在，不能加入 \n", node.no);
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }

    // 书写更新链表数据函数
    public void update(HeroNode newNode) {
        // 分为空和相等来区分计算
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean exist = false;
        while (true) {
            if (temp == null) {
                System.out.println("链表为空！");
                return;
            }
            if (temp.no == newNode.no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (exist) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newNode.no);
        }
    }

    // 删除节点操作
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean exist = false; // 是否找到要删除的节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (!exist) {
            System.out.printf("未找到匹配的编号 %d \n", no);
            return;
        }
        // 删除操作
        temp.next = temp.next.next;
    }

    // 统计有效节点的个数，即遍历链表
    public int length() {
        HeroNode temp = head.next;
        int num = 0;
        if (head.next == null) {
            return 0;
        }
        while (temp != null) {
            num++;
            temp = temp.next;
        }
        return num;
    }

    // 查找单链表中的倒数第k个节点
    public HeroNode findLastIndexNode(int index) {
        // 通过size与index的大小来判断
        int size = length();
        if (size == 0) {
            return null;
        }
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 单链表的反转
    public void reverse() {
        // 始终添加到第一个节点
        if (head.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (cur != null) {
            next = cur.next; // 储存下一个元素的指针
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public void reversePrint() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 遍历原链表，入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 打印栈
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

// 构造链表中的一个节点
class HeroNode {
    // 定义4个基本属性
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    // 书写构造函数
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    // 为显示方便重写toString函数
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
