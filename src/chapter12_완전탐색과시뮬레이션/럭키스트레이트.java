package chapter12_완전탐색과시뮬레이션;

import java.util.Scanner;

public class 럭키스트레이트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        String input = sc.nextLine();
        int length = input.length();
        int sum = 0;

        for (int i = 0; i < length / 2; i++) {
            sum += (int) input.charAt(i);
        }

        for (int i = length / 2; i < length; i++) {
            sum -= (int) input.charAt(i);
        }


        System.out.println(sum == 0 ? "LUCKY" : "READY");

    }
}
