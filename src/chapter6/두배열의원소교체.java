package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 두배열의원소교체 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Integer[] arrayA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Integer[] arrayB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);


        Arrays.sort(arrayA);
        Arrays.sort(arrayB, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (arrayA[i] < arrayB[i]) {
                int temp = arrayA[i];
                arrayA[i] = arrayB[i];
                arrayB[i] = temp;
            }
            else break;
        }

        long result = 0;
        System.out.println(Arrays.stream(arrayA).mapToInt(Integer::intValue).sum());


    }
}
