package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 모험가길드 {

    private static int n;
    private static List<Integer> groups = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            groups.add(sc.nextInt());
        }

        Collections.sort(groups);

        int groupCnt = 0;
        int currentGroupCnt = 0;

        for (int i = 0; i < groups.size(); i++) {
            currentGroupCnt += 1;

            if (currentGroupCnt >= groups.get(i)) {
                groupCnt +=1;
                currentGroupCnt = 0;
            }

        }
        System.out.println(groupCnt);
    }
}
