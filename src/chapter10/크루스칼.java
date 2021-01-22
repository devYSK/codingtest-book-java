package chapter10;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;


/**
 * 1. 간선 데이터를 비용에 따라 오름차순으로 정렬
 * 2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인
 *   2.1 사이클이 발생하지 않는 경우 최소 신장 트리에 포함
 *   2.2 사이클이 발생하는 경우 최소 신장 트리에 포함 시키지 않는다.
 *
 * 3. 모든 간선에 대하여 2번의 과정 반복
 *
 * 최종적인 신장 트리의 간선 개수 = 노드(정점)의 개수 - 1
 *
 */
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

        // 간선 정보 입력받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
        }

        //간선을 비용순으로 정렬
        Collections.sort(edges);



        for (Edge edge : edges) {
            int cost = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();

            // 사이클이 발생하지 않는 경우에만 집합에 포함.
            if (findParent(a) != findParent(b)) {
                union(a, b);
                result += cost;
            }

        }

        for (Edge edge : edges) {
            System.out.println(edge);
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

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }


    @Override
    public String toString() {
        return
                "distance=" + distance +
                ", nodeA=" + nodeA +
                ", nodeB=" + nodeB +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.distance, o.getDistance());
    }


}

