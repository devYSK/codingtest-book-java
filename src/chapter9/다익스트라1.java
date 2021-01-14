package chapter9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라1 { // 간단한 다익스트라 알고리즘 소스코드

    static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }

    private static final int INF = (int) 1e9; // 10억
    private static int n, m, start;

    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();


    private static boolean[] visited = new boolean[100001];

    private static int[] table = new int[100001];

    // 방문하지 않는 노드 중에서, 가장 최단 거리가 짧은 노드의 인덱스를 반환.
    private static int getSmallestNode() {
        int minValue = INF;

        int index = 0;

        for (int i = 1; i <= n; i++) {
            // 방문하지 않았고, 가장 거리가 짧다면 짧은 거리를 minValue로 갱신
            if (table[i] < minValue && !visited[i]) {
                minValue = table[i];
                index = i;
            }
        }

        return index;
    }

    public static void dijkstra(int start) {
        table[start] = 0;

        visited[start] = true;

        // 테이블의 거리를 초기화
        for (int i = 0; i < graph.get(start).size(); i++) {
            table[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1 개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리
            int currentIdx = getSmallestNode();
            visited[currentIdx] = true;

            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(currentIdx).size(); j++) {
                int cost = table[currentIdx] + graph.get(currentIdx).get(j).getDistance();
                int otherIdx = graph.get(currentIdx).get(j).getIndex();

                // 현재 노드를 거쳐 다른 노드로 이동하는 비용이 더 짧은 경우 테이블 갱신
                if (cost < table[otherIdx]) {
                    table[graph.get(currentIdx).get(j).getIndex()] = cost;
                }

            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // 모든 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int distance = sc.nextInt();

            graph.get(a).add(new Node(b, distance));

        }

        Arrays.fill(table, INF);

        dijkstra(start);


        // 모든 노드로 가기 위한 최단 경로 출력
        for (int i = 1; i <= n; i++) {

            if (table[i] == INF)
                System.out.println("INFINITY");
            else
                System.out.println(table[i]);
        }


    }


}

