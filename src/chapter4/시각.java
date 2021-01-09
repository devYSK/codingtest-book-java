package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        String input = br.readLine();

        int col = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';


        System.out.println("col = " + col + ", row = " + row);
    }
}
