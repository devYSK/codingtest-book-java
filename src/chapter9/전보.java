package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {

    private static int n, m, c; // c 는 출발하고자 하는 노드

    private static final int INF = (int)1e9;

    private static int[] table = new int[30001];

    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void solution(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        table[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int currentDistance = node.getDistance();
            int currentIdx = node.getIndex();

            if (table[currentIdx] < currentDistance) continue;

            for (int i = 0; i< graph.get(currentIdx).size(); i++) {
                int otherCost = table[currentIdx] + graph.get(currentIdx).get(i).getDistance();
                int otherIdx = graph.get(currentIdx).get(i).getIndex();

                if (otherCost < table[otherIdx]) {
                    table[otherIdx] = otherCost;
                    pq.offer(new Node(otherIdx, otherCost));
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 도시의 개수
        m = sc.nextInt(); // 통로의 개수
        c = sc.nextInt(); // 메시지를 보내고자 하는 도시 C

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph.get(x).add(new Node(y, z));
        }

        Arrays.fill(table, INF);

        solution(c); // 메시지를 보내고자 하는 도시부터 다익스트라 알고리즘 수행

        int count = 0;

        int maxDistance = 0; // 도달할 수 있는 노드중에서 가장 멀리 있는 노드와의 최단 거리

        for (int i = 1; i <= n; i++) {
            if (table[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, table[i]);
            }
        }

        // 시작 노드는 제외하므로 count에서 -1
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
