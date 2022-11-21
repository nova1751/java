package DataStructure.Tree;

public class ArrBinaryTreeTest {
    // 构造前序遍历函数
    public void preOrder() {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder(0);
    }

    public void infixOrder() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.infixOrder(0); // 4,2,5,1,6,3,7
    }

    public void postOrder() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.postOrder(0); // 4,5,2,6,7,3,1
    }

}

// 书写ArrBinaryTree类
class ArrBinaryTree {
    int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (arr == null && arr.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        System.out.println(arr[index]);
        int left = 2 * index + 1;
        if (left < arr.length) {
            preOrder(left);
        }
        int right = 2 * index + 2;
        if (right < arr.length) {
            preOrder(right);
        }
    }

    // 另外两种遍历比较简单，调整顺序即可
    /**
     * 中序遍历：先遍历左子树，再输出父节点，再遍历右子树
     *
     * @param index
     */
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能前序遍历二叉树");
            return;
        }
        int left = 2 * index + 1;
        if (left < arr.length) {
            infixOrder(left);
        }
        System.out.println(arr[index]);
        int right = 2 * index + 2;
        if (right < arr.length) {
            infixOrder(right);
        }
    }

    /**
     * 后序遍历：先遍历左子树，再遍历右子树，最后输出父节点
     *
     * @param index
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能前序遍历二叉树");
            return;
        }
        int left = 2 * index + 1;
        if (left < arr.length) {
            postOrder(left);
        }
        int right = 2 * index + 2;
        if (right < arr.length) {
            postOrder(right);
        }
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        ArrBinaryTreeTest arrBinaryTreeTest = new ArrBinaryTreeTest();
        arrBinaryTreeTest.preOrder();
    }
}
