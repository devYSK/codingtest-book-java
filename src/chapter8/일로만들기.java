package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int result = 0;

        int[] dp = new int[30001];


        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);

            if (i % 5 == 0)
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
        }

        System.out.println(dp[x]);

    }
}
