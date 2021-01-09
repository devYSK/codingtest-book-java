package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이될때까지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int count = 0;

        while (n != 1) {
            if (n % k != 0) {
                n -= 1;
            } else {
                n = n / k;
            }
            count ++;

        }

        System.out.println(count);

    }
}
