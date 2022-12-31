package DataStructure.DoubleLinkedListPackage;

class HeroNode {
    // 基本的元素与构造元素与单链表基本相同，主要多了一个pre域
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode pre;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    // 重写函数也基本一致
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

// 对双向链表类进行编写
public class DoubleLinkedList {
    // 同样的，初始化一个最初的节点
    private HeroNode head = new HeroNode(0, "", "");

    // 将节点添加到链表的尾部
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    // 修改值的函数，与单向链表基本相同
    public void update(HeroNode newNode) {
        if (head.next == null) {
            System.out.println("The linked list is empty!");
            return;
        }

        HeroNode temp = head;
        boolean exist = false;
        while (true) {
            if (temp.next == null) {
                break;
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
            System.out.printf("no element found with number: %d !", newNode.no);
        }
    }

    // 删除函数与单向链表的思路基本相同，需要注意删除的操作以及最后一位元素的删除处理
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("The linked list is empty!");
            return;
        }

        HeroNode temp = head.next;
        boolean exist = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (!exist) {
            System.out.printf("no element found with number: %d !", no);
            return;
        }
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
        temp.pre.next = temp.next;
    }

    // 打印链表
    public void print() {
        if (head.next == null) {
            System.out.println("The linked list is empty!");
            return;
        }
        HeroNode cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    // 按序添加
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean exist = false; // 添加的节点是否已经在链表中存在

        while (true) {
            // 已到列表尾部
            if (temp.next == null) {
                break;
            }
            // 已找到
            if (temp.next.no > node.no) {
                break;
            }

            // 已存在该编号
            if (temp.next.no == node.no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        if (exist) {
            System.out.printf("The phantom thief number %d to be inserted already exists and can't be added! \n", node.no);
            return;
        }

        // 把节点插入到 temp 和 temp.next 之间
        // temp -> node -> temp.next
        node.next = temp.next;
        temp.next = node;
        node.pre = temp.next.pre;
        temp.next.pre = node;
    }
}
