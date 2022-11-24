package DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIDefaults.ProxyLazyValue;

import org.ietf.jgss.Oid;

public class GraphTest {
    public void graphTest() {
        int n = 5;
        String vertexValue[] = { "A", "B", "C", "D", "E" };
        Grap grap = new Grap(n);
        for (String value : vertexValue) {
            grap.insertVertex(value);
        }
        grap.insertEdge(0, 1, 1);
        grap.insertEdge(0, 2, 1);
        grap.insertEdge(1, 2, 1);
        grap.insertEdge(1, 3, 1);
        grap.insertEdge(1, 4, 1);
        grap.showGraph();
        System.out.println("边：" + grap.getNumOfEdges());
        System.out.println("下标 1:" + grap.getValueByIndex(1));
    }

    // 编写grap类
    class Grap {
        private List<String> vertexs;
        private int[][] edges;
        private int numOfEdges = 0;

        public Grap(int n) {
            vertexs = new ArrayList<>();
            edges = new int[n][n];
        }

        public void insertVertex(String vertex) {
            vertexs.add(vertex);
        }

        public void insertEdge(int v1, int v2, int weight) {
            edges[v1][v2] = weight;
            edges[v2][v1] = weight;
            numOfEdges++;
        }

        public int getNumOfVertex() {
            return vertexs.size();
        }

        public int getNumOfEdges() {
            return numOfEdges;
        }

        public String getValueByIndex(int i) {
            return vertexs.get(i);
        }

        public void showGraph() {
            System.out.printf(" ");
            for (String vertex : vertexs) {
                System.out.printf(vertex + " ");
            }
            System.out.println();
            for (int i = 0; i < edges.length; i++) {
                System.out.printf(vertexs.get(i) + " ");
                for (int j = 0; j < edges.length; j++) {
                    System.out.printf(edges[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        GraphTest graphTest=new GraphTest();
        graphTest.graphTest();
    }
}
