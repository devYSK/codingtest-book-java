package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 위상 정렬은 순서가 정해져 있는 일련의 작업을
 * 차례대로 수행해야 할 때 사용할 수 있는 알고리즘이다. 조금 더 이론적으로 설명하자면,
 * 위상 정렬이란 빙향 그래프의 모든 노드를 ‘방향성에 거스르지 않도록 순서 대로 나열하는 것'이다
 */
public class 위상정렬 {

    private static int v, e;

    private static int[] indegree = new int[100001];

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private static void topologySort() {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }


        while(!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -=1;

                if (indegree[graph.get(now).get(i)] == 0)
                    q.offer(graph.get(now).get(i));
            }
        }

    }
}
