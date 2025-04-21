import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        Integer[] B = new Integer[n];  // Integer[]로 변경

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);  // 오름차순

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        Arrays.sort(B, Comparator.reverseOrder());  // 내림차순

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += A[i] * B[i];
        }

        System.out.println(ans);
    }
}