package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class 미래도시 {


    private static final int INF = (int)1e9;
    private static int graph[][] = new int[101][101]; // N <= 100

    // 노드의 개수(N), 간선의 개수(M), 거쳐 갈 노드(X), 최종 목적지 노드(K)
    private static int n, m, x, k; //


   //A는 1번 회사에서 출발하여 K번 회사를 빙문한 뒤에 X번 회사로 가는 것이 목표

    private static int solution() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 전체 회사의 갯수
        m = sc.nextInt(); // 경로의 갯수

        for (int i =0 ; i < 101; i++) { // 초기화
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < m; i++) {
            // 비용은 = 1; 양방향 그래프
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // k번 단계에 대한 반복
        // a에서 b로가는 비용과, a에서 k를 걸쳐 k에서 b로가능 비용을 비교하여 더 작은 최솟값으로 대입
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b<= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        return distance >= INF ? -1 : distance;
    }


    public static void main(String[] args) {
        System.out.println(solution());
    }
}

