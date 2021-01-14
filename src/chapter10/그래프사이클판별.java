package chapter10;

import java.util.Scanner;

public class 그래프사이클판별 {

    private static int v, e;
    private static int[] parent = new int[100001];

    private static int findParent(int x) { // 특정 원소가 속한 집합을 찾기. find함수

        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기. 배열의 부모 노드 갱신
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블에서 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        boolean isCycle = false;

        for (int i = 0; i < e; i++) {// 간선의 갯수만큼
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (findParent(a) == findParent(b)) { // 사이클 판별. 같은 부모를 가지고 있으면 사이클이 있는것
                isCycle = true;
                break;
            }
            else
                unionParent(a, b);


        }

        if (isCycle)
            System.out.println("사이클 발생");
        else
            System.out.println("노사이클");
    }

}
