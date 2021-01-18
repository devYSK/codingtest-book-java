package chapter10;

import java.util.Scanner;

public class 팀결성 {

    private static int n, m;

    private static int[] team;

    // union
    private static int findTeam(int x) {
        if (x == team[x])
            return x;

        return team[x] = findTeam(team[x]);
    }

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


        }

    }

}
