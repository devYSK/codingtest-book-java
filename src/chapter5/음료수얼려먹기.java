package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 음료수얼려먹기 {


    private static int[][] map;
    private static int n;
    private static int m;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0 ; i < n ; i++) {
            map[i] = br.readLine().chars().map(operand -> operand - '0').toArray();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    System.out.println("i = " + i + ", j = " + j + "  true!! ");
                    result ++;
                }
            }
        }

        System.out.println(result);

    }


    public static boolean dfs(int x, int y) {
        // 지정된 범위를 넘어가는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y>= m) {
            return false;
        }


        if (map[x][y] == 0) {
            map[x][y] = 1;

            // 상, 하ㅣ, 좌, 우 모든 위치들도 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }

        return false;
    }

}
