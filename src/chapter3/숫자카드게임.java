package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자카드게임 {

    public static void solution1() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][m];


        int result = 0;
        for (int i = 0; i < n; i++) {
//            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).min().getAsInt();

            result = Math.max(result, min);
        }

        System.out.println(result);


    }
}
