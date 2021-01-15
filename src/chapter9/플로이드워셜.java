package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드워셜 {
    private static final int INF = (int)1e9; // 무한 의미하는 10억

    private static int n, m;


    private static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 갯수
        m = sc.nextInt(); // 간선 갯수

        for (int[] ints : graph) {
            Arrays.fill(ints, INF);
        }

        // 자기자신에서 자기자신으로 가면 0으로 초기화. 못가는 길이라는 뜻
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // a에서 b로가는 비용은 c
            graph[a][b] = c;
        }

        // 플로이드 워셜 알고리즘 수행
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }


        // 결과 출력

        print();

    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) System.out.print("INFINITY");
                else System.out.print(graph[i][j] + " ");
            }
        System.out.println();
        }
    }


}
