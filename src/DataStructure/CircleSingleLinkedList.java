package DataStructure;

// 构造孩子节点
class Boy {
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }
}

public class CircleSingleLinkedList {
    Boy first = null;

    /*
     * 添加节点
     * 1. 检查num的输入是否在1及以上
     * 2. 通过cur指针循环前移，创建环形单列表
     * 3. 第一个节点为空的时候需要特殊考虑
     * 4. 添加节点的顺序为：cur指向boy,boy指向first,cur指针指向boy
     */
    public void add(int num) {
        if (num < 1) {
            System.out.println("请输入大于1的数字！");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (first == null) {
                first = boy;
                boy.next = first;
                cur = first;
                continue;
            }
            cur.next = boy;
            boy.next = first;
            cur = boy;
        }
    }

    /**
     * 打印队列
     */
    public void print() {
        if (first == null) {
            System.out.println("队列为空");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("小孩编号 %d \n", cur.no);
            cur = cur.next;
            // 如果和 first 一致，则标识已经走了一圈了
            if (cur == first) {
                return;
            }
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        // 进行一个数据校验
        if (first == null || // 环形队列没有构建
                countNum < 1 || // 每次至少数 1 下
                startNo > nums // 开始小孩不能大于参与游戏的人数
        ) {
            System.out.println("参数有误，请重新输入");
        }
        // 1. 初始化辅助变量到 first 的后面
        Boy helper = first;
        // 当 helper.next = first 时，就说明已经定位了
        while (helper.next != first) {
            helper = helper.next;
        }

        // 2. 定位 first 和 helper 在 startNo 位置
        // first 初始在最开始，移动到 startNo 位置
        for (int i = 0; i < startNo - 1; i++) {
            helper = first;
            first = first.next;
        }

        // 为了测试方便，这里添加一个日志输出
        System.out.printf("定位到位置： %d \n", startNo);
        print();

        // 3. 开始报数 和 出圈
        while (true) {
            // 当队列中只剩下一个人的时候，跳出循环，因为最后一个必然是他自己出队列
            if (helper == first) {
                break;
            }
            // 报数：每次报数 m-1
            for (int i = 0; i < countNum - 1; i++) {
                // 因为 helper 永远在 first 后面，只要在 first 移动时，指向 first 原来所在的位置即可
                helper = first;
                first = first.next;
            }
            // 出圈
            System.out.printf("出圈小孩编号 %d \n", first.no);
            first = first.next; // first 重置为下一次报数的小孩节点上
            helper.next = first; // helper 重置为下一次报数的小孩节点上
        }
        System.out.printf("最后剩下小孩编号 %d \n", first.no);
    }
}
