package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {

    private static int n, m, c; // c 는 출발하고자 하는 노드

    private static final int INF = (int)1e9;

    private static int[] table = new int[30001];

    private static ArrayList<Node[]> graph = new ArrayList<>();

    public static void solution() {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(c, 0));

        table[c] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int distance = node.getDistance();
            int nowIdx = node.getIndex();

            if (table[nowIdx] < distance)
                continue;

            for (int i = 0; i < graph.get(nowIdx).length; i++) {
                int cost = table[nowIdx] + graph.get(nowIdx)[i].getDistance();

                if (cost < table[graph.get(nowIdx)[i].getIndex()]) {
                    table[graph.get(nowIdx)[i].getIndex()] = cost;
                    pq.offer(new Node(graph.get(nowIdx)[i].getIndex(), cost));
                }
            }

        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new Node[n]);
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            // x번 노드 -> y번 노드 까지 거리 = z
            graph.get(x)[i] = new Node(y, z);
        }

        Arrays.fill(table, INF);

// 다익스트라 알고리즘을 수행
        solution();

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            // 도달할 수 있는 노드인 경우
            if (table[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, table[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);


    }

    private static class Node implements Comparable<Node> {
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
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.getDistance());
        }
    }
}
