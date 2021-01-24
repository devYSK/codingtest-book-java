package chapter10;

import java.util.Arrays;
import java.util.Scanner;

public class 팀결성 {

    private static int n, m;

    private static int[] team;

    // 특정 원소가 속한 집합을 찾기 [어느 팀 찾기]
    private static int findTeam(int x) {

        System.out.println("x = " + x + ", team[x] = " + team[x]);
        if (x == team[x])
            return x;


        return team[x] = findTeam(team[x]);
    }

    // 두 원소가 속한 집합을 합치기 [ 팀 합치기 ]
    private static void unionTeam(int a, int b) {
        a = findTeam(a);
        b = findTeam(b);

        if (a < b)
            team[b] = a;
        else
            team[a] = b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 학생 수
        m = sc.nextInt(); // 연산 숫자

        team = new int[n + 1];

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            team[i] = i;
        }

        // 0 = 팀 합치기, 1 = 팀 여부 확인
        for (int i = 0; i < m; i++) {
            int operand = sc.nextInt();
            int teamA = sc.nextInt();
            int teamB = sc.nextInt();

            if (operand == 0)
                unionTeam(teamA, teamB);
            else {
                if (findTeam(teamA) == findTeam(teamB))
                    System.out.println("YES");
                else
                    System.out.println("No");
            }

            System.out.print("table = [");
            for (int j = 0; j < n + 1; j++)
                System.out.print(j + ", ");
            System.out.println("]");
            System.out.println("table = " + Arrays.toString(team));

        }

        System.out.println(Arrays.toString(team));

    }

}
