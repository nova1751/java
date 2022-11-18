package DataStructure.Tree;

public class BinaryTree {
    // 先编写二叉树节点
    class HeroNode {
        public int id;
        public String name;
        public HeroNode left;
        public HeroNode right;

        public HeroNode(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // 重写object类的toString方法
        @Override
        public String toString() {
            return "HeroNode{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        /*
         * 前序遍历
         */
        public void preOrder() {
            // 输出当前节点
            System.out.println(this);
            // 输出左节点
            if (this.left != null) {
                this.left.preOrder();
            }
            // 输出右节点
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        /*
         * 中序遍历
         */
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        /*
         * 后序遍历
         */
        public void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }

        // 构造前序遍历搜索函数
        public HeroNode preOrderSearch(int id) {
            System.out.println("进入前序遍历:");
            if (this.id == id) {
                return this;
            }
            if (this.left != null) {
                HeroNode result = this.left.preOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            if (this.right != null) {
                HeroNode result = this.right.preOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }

        /**
         * 中序查找
         */
        public HeroNode infixOrderSearch(int id) {
            // System.out.println(" 进入中序遍历"); // 用来统计查找了几次，不能在这里打印，这里打印是进入了方法几次，看的是比较了几次
            // 1. 如果左子节点不为空，则递归继续前序遍历
            if (this.left != null) {
                HeroNode result = this.left.infixOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            System.out.println("  进入中序遍历");
            // 2. 如果相等，则返回
            if (this.id == id) {
                return this;
            }

            // 3. 如果右子节点不为空，则递归继续前序遍历
            if (this.right != null) {
                HeroNode result = this.right.infixOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }

        /**
         * 后序查找
         */
        public HeroNode postOrderSearch(int id) {
            // System.out.println(" 进入后序遍历"); // 用来统计查找了几次，不能在这里打印，这里打印是进入了方法几次，看的是比较了几次
            // 1. 如果左子节点不为空，则递归继续前序遍历
            if (this.left != null) {
                HeroNode result = this.left.postOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            // 2. 如果右子节点不为空，则递归继续前序遍历
            if (this.right != null) {
                HeroNode result = this.right.postOrderSearch(id);
                if (result != null) {
                    return result;
                }
            }
            System.out.println("  进入后序遍历");
            // 3. 如果相等，则返回
            if (this.id == id) {
                return this;
            }
            return null;
        }
    }

    // 编写二叉树对象
    class BinaryTreeDemo {
        public HeroNode root;

        /*
         * 前序遍历
         */
        public void preOrder() {
            if (root == null) {
                System.out.println("二叉树为空!");
                return;
            }
            root.preOrder();
        }

        /*
         * 中序遍历
         */
        public void infixOrder() {
            if (root == null) {
                System.out.println("二叉树为空");
                return;
            }
            root.infixOrder();
        }

        /*
         * 后序遍历
         */
        public void postOrder() {
            if (root == null) {
                System.out.println("二叉树为空！");
                return;
            }
            root.postOrder();
        }

        /**
         * 前序查找
         */
        public HeroNode preOrderSearch(int id) {
            if (root == null) {
                System.out.println("二叉树为空");
                return null;
            }
            return root.preOrderSearch(id);
        }

        /**
         * 中序查找
         */
        public HeroNode infixOrderSearch(int id) {
            if (root == null) {
                System.out.println("二叉树为空");
                return null;
            }
            return root.infixOrderSearch(id);
        }

        /**
         * 后序查找
         */
        public HeroNode postOrderSearch(int id) {
            if (root == null) {
                System.out.println("二叉树为空");
                return null;
            }
            return root.postOrderSearch(id);
        }

    }

    public void fun1() {
        // 创建节点与构建二叉树
        HeroNode n1 = new HeroNode(1, "宋江");
        HeroNode n2 = new HeroNode(2, "无用");
        HeroNode n3 = new HeroNode(3, "卢俊");
        HeroNode n4 = new HeroNode(4, "林冲");
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        BinaryTreeDemo binaryTree = new BinaryTreeDemo();
        binaryTree.root = n1;

        System.out.println("\n 前序遍历：");
        binaryTree.preOrder();
        System.out.println("\n 中序遍历：");
        binaryTree.infixOrder();
        System.out.println("\n 后序遍历：");
        binaryTree.postOrder();
    }
    
    public void fun3() {
        // 创建节点与构建二叉树
        HeroNode n1 = new HeroNode(1, "宋江");
        HeroNode n2 = new HeroNode(2, "无用");
        HeroNode n3 = new HeroNode(3, "卢俊");
        HeroNode n4 = new HeroNode(4, "林冲");
        HeroNode n5 = new HeroNode(5, "关胜");
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        n3.left = n5;
        BinaryTreeDemo binaryTree = new BinaryTreeDemo();
        binaryTree.root = n1;

        System.out.println("找到测试：");
        int id = 5;
        System.out.println("\n前序遍历查找 id=" + id);
        System.out.println(binaryTree.preOrderSearch(id));
        System.out.println("\n中序遍历查找 id=" + id);
        System.out.println(binaryTree.infixOrderSearch(id));
        System.out.println("\n后序遍历查找 id=" + id);
        System.out.println(binaryTree.postOrderSearch(id));

        System.out.println("找不到测试：");
        id = 15;
        System.out.println("\n前序遍历查找 id=" + id);
        System.out.println(binaryTree.preOrderSearch(id));
        System.out.println("\n中序遍历查找 id=" + id);
        System.out.println(binaryTree.infixOrderSearch(id));
        System.out.println("\n后序遍历查找 id=" + id);
        System.out.println(binaryTree.postOrderSearch(id));
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.fun3();
    }

}
