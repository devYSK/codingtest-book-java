package chapter12_완전탐색과시뮬레이션;

public class 문자열압축 {

    // 내일 보고 다시 이해하기

    public static int solution(String s) {
        int answer = s.length();

        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
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
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = new StringBuilder();
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length())
                            sub.append(s.charAt(k));
                    }

                    prev = sub.toString();
                    cnt = 1;
                }

            }

            compressed += (cnt >= 2) ? cnt + prev : prev;

            answer = Math.min(answer, compressed.length());

        }

        return answer;
    }

}
