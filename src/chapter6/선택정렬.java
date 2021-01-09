package chapter6;

import java.util.Arrays;

public class 선택정렬 {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIdx] > arr[j])
                    minIdx = j;
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }


        System.out.println(Arrays.toString(arr));
    }
}
