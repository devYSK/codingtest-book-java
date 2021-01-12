package chapter9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라1 {

    public static final int INF = (int)1e9; // 무한 의미하는 10억

    public static int n, m, start; // 노드의 개수 (N), 간선의 갯수(M), 시작 노드번호 (start)

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); // 노드에 대한 정보를 담는 배열

    public static boolean[]  visited = new boolean[100001]; // 방문 여부 테이블

    public static int[] table = new int[100001]; // 최단거리 담는 테이블

    public static int getSmallestNode() { // 최단 거리가 짧은 노드의 번호를 반환
        int minValue = INF;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (table[i] < minValue && !visited[i]) { // 최단거리가 가장 짧고, 방문하지 않은 노드이면
                minValue = table[i];
                index = i;
            }
        }

        return index;
    }

    public static void dijkstra (int start) {
        table[start] = 0; // 시작 노드의 거리를 0으로 초기화

        visited[start] = true;

        for (int i = 0; i < graph.get(start).size(); i++) { // start 노드부터 시작하는 모든 간선의 거리 초기화

            int index = graph.get(start).get(i).getIndex();
            int distance = graph.get(start).get(i).getDistance();

            table[index] = distance;
        }

        // 시작 노드를 제외한 전체 n - 1 개의 노드 반복
        for (int i = 0; i < n - 1; i++) {

            int nowSmallNode = getSmallestNode(); // 최단 거리가 가장 짧은 노드를 꺼내서
            visited[nowSmallNode] = true; // 방문처리

            for (int j = 0; j < graph.get(nowSmallNode).size(); i++ ) // 현재 노드와 연결된 다른 노드 확인
            {
                int distance = table[nowSmallNode] + graph.get(nowSmallNode).get(j).getDistance();

                // 현재 노드를 거쳐 다른 노드로 이동하는 거리가 짧은 경우 갱신
                int otherNodeDistance = table[graph.get(nowSmallNode).get(j).getDistance()];
                if (distance < otherNodeDistance) {
                    int otherNodeIndex = graph.get(nowSmallNode).get(j).getIndex();
                    table[otherNodeIndex] = distance;
                }
            }

        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt(); // 노드의 갯수
        m = sc.nextInt(); // 간선의 갯수
        start = sc.nextInt(); // 시작 노드 번호

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Node>()); // 그래프 초기화

        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.print("a = " + a);
            System.out.print("b = " + b);
            System.out.print("c = " +  c);
            System.out.println();
            graph.get(a).add(new Node(b, c)); // a번 노드에서 b번 노드로 가는 비용은 c
        }

        Arrays.fill(table, INF); // 비용 초기화

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (table[i] == INF)
                System.out.println("INFINITY");
            else
                System.out.println(table[i]);
        }

    }


}

