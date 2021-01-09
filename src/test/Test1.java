package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {


    private static final String text = "가깋낗닣딯띻맇밓빟삫싷잏짛찧칳킿팋핗힣";
    private static final String jamoRef = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅇㅈㅉㅊㅋㅌㅍㅎ";

    static char[] textArr = text.toCharArray();
    static char[] jamoArr = jamoRef.toCharArray();

    public static void main(String[] args) {

        System.out.println(keyword("요"));
    }


    private static String keyword(String keyword) {
        char targetChar = keyword.charAt(keyword.length() - 1);

        char endChar = '0';

        // 입력값의 끝 문자가 ㄱ...ㅎ 인 경우
        if (targetChar <= 12622) {
            for (int i = 0; i < jamoArr.length; i++) {
                if (targetChar == jamoArr[i]) {
                    System.out.println(targetChar + " to the end: " + textArr[i + 1]);
                    endChar = textArr[i + 1];
                }
            }
        } else {
            // 입력값의 끝 문자가 가...힣 인 경우
            for (int i = 0; i < text.length(); i++) {
                System.out.println(textArr[i] + " : " + (int) textArr[i]);
                if (targetChar >= textArr[i] && targetChar < textArr[i + 1]) {
                    System.out.println(targetChar + " to the end: " + textArr[i + 1]);
                    endChar = textArr[i + 1];
                }
            }
        }

// SQL 끝 단어
        String endKeyword = keyword.substring(0, keyword.length() - 1) + endChar;
        String outSql = "SELECT brand "
                + "FROM cafe_info "
                + "\n\t\t"
                + "WHERE brand >= '{start}' and brand <= '{end}' "
                + "group by brand order by brand";
        outSql = outSql.replace("{start}", keyword).replace("{end}", endKeyword);
        System.out.println("**final SQL : " + outSql);

        return outSql;

    }
}
