package chapter11;

import java.util.Scanner;

public class 문자열뒤집기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int zeroCnt = 0;
        int oneCnt = 0;


        if (str.charAt(0) == '1') {
            zeroCnt += 1;
        } else {
            oneCnt += 1;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {

                if (str.charAt(i + 1) == '1')
                    zeroCnt +=1;
                else
                    oneCnt +=1;

            }
        }

        System.out.println(Math.min(zeroCnt, oneCnt));

    }
}
