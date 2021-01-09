package naver;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static int[] solution(int[][] blocks) {

        int n = blocks.length;
        int len = (n * (n + 1)) / 2;
//        int[] answer = new int[(n * (n + 1)) / 2];


        int[][] answer = new int[n][];

        for (int i = 1; i <= n; i++) {
            answer[i - 1] = new int[i];
        }

        for (int i = 0; i < n; i++) {
            answer[i][blocks[i][0]] = blocks[i][1];
        }

//
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < answer[i].length; j++) {
//
//                if (answer[i + 1][j] == 0)
//                    answer[i + 1][j] = answer[i][j] - answer[i+1][j+1];
//
//                if (answer[i + 1][j + 1] == 0)
//                    answer[i + 1][j + 1] = answer[i][j] - answer[i + 1][j];
//
//
//            }
//        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < answer[i].length; j++) {

                if (answer[i + 1][j] == 0) {
                    answer[i + 1][j] = answer[i][j] - answer[i + 1][j + 1];
                    answer[i + 2][j] = answer[i + 1][j] - answer[i + 2][j + 1];
                }

                if (answer[i + 1][j + 1] == 0) {
                    answer[i + 1][j + 1] = answer[i][j] - answer[i + 1][j];
                    answer[i + 2][j + 1] = answer[i + 1][j] - answer[i + 2][j];
                }


            }
        }

        System.out.println("--");

        for (int[] i : answer)
            System.out.println(Arrays.toString(i));

        System.out.println("--");


        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < answer[i].length; j++) {
                list.add(answer[i][j]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();


    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[][]{{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}})));

//        System.out.println((5 * (5 + 1 )) / 2);
    }

//    public static String solution(String m, String k) {
//
//        Queue<Character> q = new LinkedList<Character>();
//
//        for (Character c : k.toCharArray()) {
//            q.offer(c);
//        }
//
//        System.out.println(q.toString());
//
//        StringBuilder sb = new StringBuilder();
//
//
//        while (q.isEmpty()) {
//            char c = q.poll();
//
//            for (int i = 0; i < m.length(); i++) {
//                if (m.charAt(i) == c)
//                    break;
//            }
//
//        }
//
//
//
//        for (int i = 0; i < m.length(); i++) {
//
//            if (q.peek() != null)
//                if (m.charAt(i) == q.peek()) {
//                    q.poll();
//                    continue;
//                }
//
//            sb.append(m.charAt(i));
//        }
//
//        return sb.toString();
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(solution("kkaxbycyz", "abc"));
//        System.out.println(solution("acbbcdc", "abc"));
//    }
}
