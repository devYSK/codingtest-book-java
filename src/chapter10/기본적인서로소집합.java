package chapter10;

import java.util.Scanner;

public class 기본적인서로소집합 {

    private static int v, e;

    private static int[] parent = new int[1000001];// 부모 테이블

//    private static int findParent(int x) {
//        return x == parent[x] ? // 자기 자신이 루트 노드이면(부모노드)
//                x : findParent(parent[x]);
//    }
//

    //개선한 find
    private static int findParent(int x) {
//        if (parent[x] == x)
//            parent[x] = findParent(x);

        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }



    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        System.out.print("각 원소가 속한 집합 : ");

        for (int i = 1; i <= v; i++)
            System.out.print(findParent(i) + " ");

        System.out.println();

        System.out.print("부모 테이블 : ");

        for (int i = 1; i<= v; i++)
            System.out.print(parent[i] + " ");


        System.out.println();

    }




}
