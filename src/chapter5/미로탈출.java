package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    private static int[][] map;

    private static int n, m;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            x = node.getIndex();
            y = node.getDistance();

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 정해진 공간을 벗어난 경우
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;

                // 벽인경우
                if (map[nextX][nextY] == 0)
                    continue;

                // 지나갈 수 있는 길일때
                // 해당 노드를 방문하는 경우에만 거리 기록
                if (map[nextX][nextY] == 1) {
                    map[nextX][nextY] = map[x][y] + 1;
                    queue.offer(new Node(nextX, nextY));
                }

            }

        }

        // 가장 오른쪽 아래까지의 최단 거리 반환

        print();
        return map[n - 1][m - 1];
    }


    private static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().chars().map(value -> value - '0').toArray();

        }


        System.out.println(bfs(0, 0));

    }


}
class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}
