package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class 왕실의나이트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int col = input.charAt(0) - 'a' + 1; // 1
        int row = input.charAt(1) - '0';  //

        // 나이트가 이동할수 있는 경우의 수

        int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1  };
        int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2 };

        int result = 0;

        for (int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];


//            if (nextRow >= 1 && nextRow <= 8  && nextCol >= 1 && nextCol <= 8) result++;
            if (nextRow < 1 || nextRow > 8 || nextCol < 1 || nextCol > 8) continue;

            result++;
        }

        System.out.println(result);
    }


}
