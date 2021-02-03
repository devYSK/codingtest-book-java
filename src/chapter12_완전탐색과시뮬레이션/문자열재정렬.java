package chapter12_완전탐색과시뮬레이션;

import java.util.*;
import java.util.stream.Collectors;

public class 문자열재정렬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        List<Character> strList = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                sum += str.charAt(i) - '0';
            } else {
                strList.add(str.charAt(i));
            }

        }

        Collections.sort(strList);
        String result = strList.stream().map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result + sum);
    }

}
