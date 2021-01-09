package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 상하좌우 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //char[] move = {'L', 'R', 'U', 'D'};
        HashMap<Character, int[]> move = new HashMap<>();
        move.put('L', new int[]{0, -1});
        move.put('R', new int[]{0, 1});
        move.put('U', new int[]{-1, 0});
        move.put('D', new int[]{1, 0});

        String[] plans = br.readLine().split(" ");

        int curX = 1;
        int curY = 1;

        for (String plan : plans) {

            int[] next = move.get(plan.charAt(0));
            int nextX = curX + next[0];
            int nextY = curY + next[1];

            if (nextX < 1 || nextX > n || nextY < 1 || nextY > n) continue;

            curX = nextX;
            curY = nextY;

        }

        System.out.println(curX + " " + curY);
    }
}
