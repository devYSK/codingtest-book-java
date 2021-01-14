package chapter9;

import java.util.*;

public class 다익스트라2 {

    static class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node other) {
            return this.distance < other.distance ? -1 : 1;
        }


    }

    private static final int INF = (int) 1e9;

    private static int n, m, start;

    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    private static int[] table = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드의 최단 경로는 0
        pq.offer(new Node(start, 0));

        table[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int dist = node.getDistance();
            int currentIdx = node.getIndex();

            // 현재 노드가 이미 처리된 노드라면 무시
            if (table[currentIdx] < dist) continue;

            for (int i = 0; i < graph.get(currentIdx).size(); i++) {
                int cost = table[currentIdx] + graph.get(currentIdx).get(i).getDistance();

                int nextIdx = graph.get(currentIdx).get(i).getIndex();

                // 다른 노드로 이동하는 거리가 더 짧은 경우 갱신
                if (cost < table[nextIdx]) {
                    table[nextIdx] = cost;
                    pq.offer(new Node(nextIdx, cost));
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
