package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 위상 정렬은 순서가 정해져 있는 일련의 작업을
 * 차례대로 수행해야 할 때 사용할 수 있는 알고리즘이다. 조금 더 이론적으로 설명하자면,
 * 위상 정렬이란 빙향 그래프의 모든 노드를 ‘방향성에 거스르지 않도록 순서 대로 나열하는 것'이다
 * <p>
 * <p>
 * 1. 진입차수가 0인 노드를 큐에 넣는다
 * 2. 큐가 빌떄까지 다음의 과정 반복
 * 1. 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거
 * 2. 새롭게 진입차수가 0이된 노드를 큐에 넣는다.
 */
public class 위상정렬 {

    // 노드의 개수(v) 간선 수 (e)
    private static int v, e;

    private static int[] indegree = new int[100001]; // 진입 차수

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private static void topologySort() {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }


        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = q.poll();
            result.add(now);
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        // 위상 정렬을 수행한 결과 출력
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); // 정점 A에서 B로 이동 가능
            // 진입 차수를 1 증가
            indegree[b] += 1;
        }

        topologySort();
    }
}
