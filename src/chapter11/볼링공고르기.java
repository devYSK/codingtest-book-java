package chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 볼링공고르기 {

    private static int n, m;

    private static int[] ballWeights = new int[11]; // 볼링공 무게는 1 ~ 10


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        List<Integer> inputs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            inputs.add(sc.nextInt());
        }

        for (int num : inputs) {
            ballWeights[num] += 1;
        }


        int result = 0;

        for (int i = 0; i < m + 1; i++) {
            n -= ballWeights[i];
            result += ballWeights[i] * n;
        }

        System.out.println(result);


    }
}
