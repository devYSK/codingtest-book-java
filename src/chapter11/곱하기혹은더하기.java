package chapter11;

import java.util.Arrays;
import java.util.Scanner;

public class 곱하기혹은더하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        int result = 1;

        for (int num : numbers) {
            if (num != 0)
                result *= num;
        }

        System.out.println(result);


    }
}
