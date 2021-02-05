package chapter12_완전탐색과시뮬레이션;

public class 문자열압축 {

    // 내일 보고 다시 이해하기

    public static int solution(String s) {
        int answer = s.length();

        // n(문자열의 길이)
        // 1부터 n/2까지의 모든 수를 단위로 하여 탐색하고 가장 짧게 압축되는 길이 출력
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, step);
            int cnt = 1;

            for (int j = step; j < s.length(); j+= step)   {
                StringBuilder sub = new StringBuilder();
                for (int k = j; k < j + step; k++) {
                    if (k < s.length())
                        sub.append(s.charAt(k));
                }

                if (prev.equals(sub.toString())) {
                    cnt +=1;
                } else {
                    compressed.append((cnt >= 2) ? cnt + prev : prev);
                    sub = new StringBuilder();
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length())
                            sub.append(s.charAt(k));
                    }

                    prev = sub.toString();
                    cnt = 1;
                }

            }

            compressed.append((cnt >= 2) ? cnt + prev : prev);

            answer = Math.min(answer, compressed.length());

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));

    }
}
