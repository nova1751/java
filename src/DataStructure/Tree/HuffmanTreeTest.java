package DataStructure.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeTest {
    public void createHuffmanTreeTest() {
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        Node huffmanTree = createHuffmanTree(arr);

        // 前序遍历
        huffmanTree.list();
    }

    private Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
        HuffmanTreeTest huffmanTreeTest = new HuffmanTreeTest();
        huffmanTreeTest.createHuffmanTreeTest();
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    // 构造函数方法
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        // 转化为字符串格式
        return value + "";
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void list() {
        System.out.println(this.value);
        if (this.left != null) {
            this.left.list();
        }
        if (this.right != null) {
            this.right.list();
        }
    }
}
