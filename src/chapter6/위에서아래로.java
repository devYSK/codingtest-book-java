package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 위에서아래로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            array.add(Integer.parseInt(br.readLine()));
        }

        array.sort(Collections.reverseOrder());

        System.out.println(array.toString());
    }
}
