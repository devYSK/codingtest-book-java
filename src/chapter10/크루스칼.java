package chapter10;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;

public class 크루스칼 {


    private static int e, v;

    private static int[] parent = new int[100001];// 유니온 파인드 테이블

    private static ArrayList<Edge> edges = new ArrayList<>();
    private static int result = 0;

    private static int findParent(int x) {

        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt(); // 정점 수
        e = sc.nextInt(); // 간선 수

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            if (findParent(a) != findParent(b)) {
                union(a, b);
                result += cost;
            }

        }
        System.out.println(result);

    }

}

class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public void setNodeA(int nodeA) {
        this.nodeA = nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public void setNodeB(int nodeB) {
        this.nodeB = nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.distance, o.getDistance());
    }


}

