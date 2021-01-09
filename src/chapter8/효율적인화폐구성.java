package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 효율적인화폐구성 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]); // n가지의 종류의 호파ㅖ
        int m = Integer.parseInt(inputs[1]); // 합 m

        int[] arr = new int[n];

        int[] dp = new int[m + 1];

        Arrays.fill(dp, 10001); // m의 최대크기가 10000이므로 불가능한 수로 10001 설정

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        dp[0] = 0;

        System.out.println("arr = " + Arrays.toString(arr));

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j < m + 1; j++) {
                if (dp[j - arr[i]] != 10001)
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }

            System.out.println(Arrays.toString(dp));
        }


        System.out.println(dp[m] == 10001 ? -1 : dp[m]);


    }
}
