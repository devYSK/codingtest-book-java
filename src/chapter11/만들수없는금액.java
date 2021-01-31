package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 만들수없는금액 {

    private static List<Integer> coins = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }

        Collections.sort(coins);


        int target = 1;

        for (int i = 0; i < coins.size(); i++) {

            if (target < coins.get(i))
                break;


            target += coins.get(i);

        }


        System.out.println(coins);

        System.out.println(target);


    }
}
