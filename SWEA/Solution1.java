package mid;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int max = 0;
            int sum;

            int[] arrA = new int[N];
            for (int a = 0; a < N; a++) {
                arrA[a] = scanner.nextInt();
            }
            int[] arrB = new int[M];
            for (int b = 0; b < M; b++) {
                arrB[b] = scanner.nextInt();
            }

            if (N > M) {
                int temp = N;
                N = M;
                M = temp;

                int[] tempArr = arrA;
                arrA = arrB;
                arrB = tempArr;
            }

            for (int j = 0; j <= (M - N); j++) {
                sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += arrA[k] * arrB[k + j];
                }

                if (max < sum) {
                    max = sum;
                }
            }

            System.out.println("#" + i + " " + max);
        }
        scanner.close();
    }
}
