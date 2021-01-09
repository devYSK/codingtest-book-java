package chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 부품찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] partNums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());

        int[] requestPartNums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(partNums);

        for (int i = 0; i < m; i++) {
            if (binarySearch(partNums, requestPartNums[i]) == -1)
                System.out.print("no ");
            else
                System.out.print("yes ");
        }

    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return mid;

            else if (arr[mid] > target) end = mid - 1;

            else start = mid + 1;


        }

        return -1;
    }
}
