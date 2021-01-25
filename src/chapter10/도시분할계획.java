package chapter10;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 도시분할계획 {

    private static int n, m; // 집의개수 n 길의 개수 m


    private static int[] parentTable = new int[100001];


    private static ArrayList<Node> nodes = new ArrayList<>();
    private static int sum = 0;


    private static int findParent(int x) {

        if (x == parentTable[x])
            return x;

        return parentTable[x] = findParent(parentTable[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        // 더 작은값이 부모
        if (a < b) {
            parentTable[b] = a;
        } else {
            parentTable[a] = b;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();


        for (int i = 1; i <= m; i++) {
            parentTable[i] = i;
        }


        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int cost = scanner.nextInt();

            nodes.add(new Node(cost, a, b));
        }

        // 비용순으로 정렬
        Collections.sort(nodes);


        int lastNodeCost = 0; // 최소 신장 트리에 포함되는 간선 중에서 비용이 가장 큰 간선

        for (Node node : nodes) {
            int cost = node.getDistance();
            int a = node.getNodeA();
            int b = node.getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);

                sum += cost;
                lastNodeCost = cost;
            }
        }

        System.out.println(sum - lastNodeCost);

    }

    static class Node implements Comparable<Node> {

        private int distance;
        private int nodeA;
        private int nodeB;


        public Node(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        // 비용이 짧은 노드가 높은 우선순위
        @Override
        public int compareTo(Node o) {
            return this.distance < o.distance ? -1 : 1;
        }
    }
}
