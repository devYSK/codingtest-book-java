package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임개발 {

    private static int direction;

    public static void main(String[] args) throws IOException {

        int[][] map = new int[50][50];
        int[][] visited = new int[50][50];
        // 방향 정의
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 사이즈 입력 받기
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        // 캐릭터의 위치 입력 받기
        inputs = br.readLine().split(" ");

        int curX = Integer.parseInt(inputs[0]);
        int curY = Integer.parseInt(inputs[1]);
        direction = Integer.parseInt(inputs[2]); // 0 : 북쪽, 1: 동쪽, 2 : 남쪽, 3 : 서쪽

        visited[curX][curY] = 1;


        // 전체 맵 정보 입력 받기
        // 0 : 육지, 1 : 바다
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }


        int count = 1; // 시작하자마자 이동했기 때문
        int turnCount = 0;

        while (true) {
            turnLeft();
            int nextX = curX + dx[direction];
            int nextY = curY + dx[direction];

            if (map[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
                visited[nextX][nextY] = 1;
                curX = nextX;
                curY = nextY;
                count++;

                turnCount = 0; // 0으로 초기화
                continue;
            }
            else turnCount +=1; // 회전 후 정면에 가보지 않은 칸이 없거나 바다여서 못 간경우 회전 횟수 + 1

            //네 방향 모두 갈 수 없는 경우
            if (turnCount == 4) {

                // 1칸 뒤로 돌아간다
                nextX = curX - dx[direction];
                nextY = curY - dy[direction];

                // 뒤로 돌아갈 수 있다면 ( 육지일 경우)
                if (visited[nextX][nextY] == 0) {
                    curX = nextX;
                    curY = nextY;
                }
                else break; // 뒤가 바다로 막혀 못 돌아가는 경우에 움직임을 멈춘다

                turnCount = 0;
            }

        }

        System.out.println(count);
    }


    public static void turnLeft() {
        // 하나씩 뺄 때 마다 왼쪽으로 도는것
        // 3 서 2 남 1 동 0 북
        direction -= 1;
        if (direction == -1)
            direction = 3;
    }

}
