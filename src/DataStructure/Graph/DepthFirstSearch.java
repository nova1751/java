package DataStructure.Graph;

import java.util.ArrayList;


public class DepthFirstSearch extends Grap {
    

    public DepthFirstSearch(int n) {
        super(n);
        //TODO Auto-generated constructor stub
    }

    // 存放顶点是否已经访问过，下标对应顶点插入列表的下标
    private boolean[] isVisited;

    /*
     * 深度遍历
     */
    public void dfs() {
        for (int i = 0; i < vertexs.size(); i++) {
            // 如果已经访问过，则跳过
            if (isVisited[i]) {
                continue;
            }
            dfs(i);
        }
    }

    /*
     * 深度优先遍历
     */
    public void dfs(int i) {
        // 输出自己，并标记为已经访问过
        System.out.print(vertexs.get(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (isVisited[w]) {
                w = getNextNeighbor(i, w);
            } else {
                dfs(w);
            }
        }
    }

    /*
     * 查找第一个邻接节点
     */
    private int getFirstNeighbor(int i) {
        for (int j = i; j < vertexs.size(); j++) {
            if (edges[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /*
     * 如果w节点被访问过，则查找i节点的下一个邻接节点
     */
    private int getNextNeighbor(int i, int w) {
        for (int j = w + 1; j < vertexs.size(); j++) {
            if (edges[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    public void dfsTest() {
        int n = 5;
        String vertexValue[] = { "A", "B", "C", "D", "E" };
        DepthFirstSearch grap = new DepthFirstSearch( n);
        for (String value : vertexValue) {
            grap.insertVertex(value);
        }
        // a,b a,c b,c b,d b,e
        grap.insertEdge(0, 1, 1);
        grap.insertEdge(0, 2, 1);
        grap.insertEdge(1, 2, 1);
        grap.insertEdge(1, 3, 1);
        grap.insertEdge(1, 4, 1);
        grap.showGraph();

        System.out.println();
        grap.dfs();
    }

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(5);
        depthFirstSearch.dfsTest();
    }
}
