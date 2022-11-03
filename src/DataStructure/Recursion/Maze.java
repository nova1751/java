package DataStructure.Recursion;

public class Maze {
    public void demo() {
        // 构造一个8行7列的地图
        int[][] map = initMap(8, 7);
        printMap(map);
        // 一次性没有回溯的路线
        // setWay(map, 1, 1, 6, 5);
        // 这个点是有回溯的路线
        setWay(map, 1, 1, 4, 1);
        System.out.println("路线查找完毕！");
        printMap(map);
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.demo();
    }

    /**
     * <pre>
     *  思路说明：
     *  1. 从 startX,startY 开始走，到 endX,endY 结束
     *  2. 当走到 endX,endY 时，表示已经找到了路线
     *  3. 约定：map 中的含义：
     *      0：表示该点没有走过
     *      1：表示围墙，不能走
     *      2：表示该点已走过，并且可以走
     *      3：表示该点已走过，但是走不通
     *
     *  4. 走迷宫，约定一个寻找路线的策略，也就是当你站在一个点的时候，你从哪一个方向开始探索？
     *     这里规定探索的方向为：下 -> 右 -> 上 -> 左，如果该点走不通，再回溯
     * </pre>
     *
     * @param map    代表一张地图
     * @param startX 从哪一个点开始走
     * @param startY
     * @param endX
     * @param endY
     * @return true: 表示该点可以走，false：表示改点不能走
     */
    public boolean setWay(int[][] map, int startX, int startY, int endX, int endY) {
        // 如果当结束点已经走过，表示已经达到了出口
        System.out.println();
        printMap(map); // 打开这个可以看到每一步的探索路径
        if (map[endX][endY] == 2) {
            return true;
        }

        // 如果该点没有走过可以尝试探索
        if (map[startX][startY] == 0) {
            // 先假定该点标可以通过，因为要去探索四周的点是否可以走
            map[startX][startY] = 2;
            // 下 -> 右 -> 上 -> 左
            // 根据策略：先往下走，如果可以走则返回 true
            if (setWay(map, startX + 1, startY, endX, endY)) {
                return true;
            }
            // 如果走不通，则继续往右边探索
            else if (setWay(map, startX, startY + 1, endX, endY)) {
                return true;
            }
            // 如果走不通，则继续往上边探索
            else if (setWay(map, startX - 1, startY, endX, endY)) {
                return true;
            }
            // 如果走不通，则往左边探索
            else if (setWay(map, startX, startY - 1, endX, endY)) {
                return true;
            }
            // 都走不通表示该点是一个死点，四周都无法出去
            else {
                map[startX][startY] = 3;
                return false;
            }
        } else {
            // 如果不为 0，可能的情况是：1，2，3，这三种表示都表示不可以走
            return false;
        }
    }

    /**
     * 构建一个有挡板的地图
     * 
     * <pre>
     * 数字 1：表示挡板围墙，小球不可以经过
     * 数字 0：表示是路，小球可以经过
     * 起点：可以自定义起点
     * 出口：其实也可以自定义出口，但是本题规定，出口就是右下角的 0
     * 1 1 1 1 1 1 1
     * 1 0 0 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 1 1 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 1 1 1 1 1 1
     * </pre>
     *
     * @return
     */
    private int[][] initMap(int row, int col) {
        // 构建一个8行7列的地图
        int[][] map = new int[row][col];
        // 数字1表示挡板，构建一个有挡板的地图

        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1; // 顶部增加挡板
            map[map.length - 1][i] = 1; // 底部增加挡板
        }

        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1; // 给左侧增加挡板
            map[i][map[0].length - 1] = 1; // 给右侧增加挡板
        }

        // 中间其他的固定挡板
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    // 书写打印函数
    public void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
