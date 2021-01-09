package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라2 {




    public static final int INF = (int)1e9; // 무한 의미하는 10억

    public static int n, m, start; // 노드의 개수 (N), 간선의 갯수(M), 시작 노드번호 (start)

    public static ArrayList<ArrayList<chapter9.Node>> graph = new ArrayList<ArrayList<chapter9.Node>>(); // 노드에 대한 정보를 담는 배열

    public static int[] table = new int[100001]; // 최단거리 담는 테이블


    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0)); // 자기자신은 0

        table[start] = 0;


        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int distance = node.getDistance(); // 현재 노드까지의 거리
            int nowIndex = node.getIndex();

            if (table[nowIndex] < distance) continue;// 현재 노드가 이미 처리된 적이 있다면 노드를 무시

            for (int i = 0; i < graph.get(nowIndex).size(); i++) {
                int nextCost = table[nowIndex] + graph.get(nowIndex).get(i).getDistance();

                if (nextCost < table[graph.get(nowIndex).get(i).getIndex()]) { // 거리가 더 짧은 경우
                    table[graph.get(nowIndex).get(i).getIndex()] = nextCost;
                    pq.offer(new Node(graph.get(nowIndex).get(i).getIndex(), nextCost));
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
            graph.add(new ArrayList<chapter9.Node>()); // 그래프 초기화

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.print("a = " + a);
            System.out.print("b = " + b);
            System.out.print("c = " + c);;
            graph.get(a).add(new chapter9.Node(b, c)); // a번 노드에서 b번 노드로 가는 비용은 c
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




    static class Node implements Comparable<Node>{

        int index;
        int distance;


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

            Integer.compare(this.distance, other.distance); // x < y 음수, x > y 양수

            // 반환값이 음수면 오름차순, 양수면 내림차순

            return this.distance < other.distance ? -1 : 1; //
        }
    }
}
