package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 떡볶이떡만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] riceArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;

        int end = Arrays.stream(riceArr).max().getAsInt();
        int result = 0;

        while (start <= end) {
            long totalLength = 0;
            int mid = (start + end ) / 2;

            for (int i = 0; i < n; i++) {
                if (riceArr[i] > mid)
                    totalLength += riceArr[i] - mid;
            }

            if (totalLength < m) {
                end = mid - 1;
            }
            else {
                result = mid;
                start = mid + 1;
            }

        }

        System.out.println(result);
    }
}
