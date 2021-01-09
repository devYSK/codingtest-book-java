package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 큰수의법칙 {


    public static void solution1(int n, int m, int k, int[] arr) {
        int firstLargestNum = arr[n - 1]; // 가장 큰수
        int secondLargestNum = arr[n - 2]; // 두번째로 큰 수

        int result = 0;

        while (m != 0) {
            for (int i = 0; i < k; i++) {
                if (m == 0 )
                    break;

                result += firstLargestNum;
                m -= 1;
            }

            result += secondLargestNum;
            m -= 1;
        }

        System.out.println(result);
    }


    public static void solution2(int n, int m, int k, int[] arr) {
        int firstLargestNum = arr[n - 1]; // 가장 큰수
        int secondLargestNum = arr[n - 2]; // 두번째로 큰 수
        // count : 가장 큰수가 더해지는 횟수
        int count = (m / (k + 1)) * k;

        count += m % (k + 1);

        int result = 0;

        result += (count * firstLargestNum); // 가장 큰수가 더해지는 횟수만큼 큰수를 곱한다

        // 가장 큰수를 더하는 횟수만큼을 m에서 뺀다.
        result += (m - count) * secondLargestNum; // m은 숫자가 더해지는 횟수 두번째로 큰 수를 곱해서 더한다

        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 배열의 크기
        int m = Integer.parseInt(input[1]); // 숫자가 더해지는 횟수
        int k = Integer.parseInt(input[2]); // k는 연속해서 k번을 초과하여 더해질 수 없다

        int[] arr = new int[n];

        String [] dataList = br.readLine().split(" ");

        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(dataList[i]);
        }

        Arrays.sort(arr);

        solution1(n, m, k, arr);

        solution2(n, m, k, arr);

    }
}
