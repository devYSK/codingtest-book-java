package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
