import java.util.Scanner;

public class SWEA1216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();
            int n = 100;
            char[][] arr = new char[n][n];

            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            int max = 0;

            for (int len = 1; len <= n; len++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= n - len; j++) {
                        if (palindrome(arr, i, j, len, true)) {
                            max = (len > max ? len : max);
                        }
                        if (palindrome(arr, j, i, len, false)) {
                            max = (len > max ? len : max);
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    public static boolean palindrome(char[][] arr, int x, int y, int len, boolean isWidth) {
        for (int i = 0; i < len / 2; i++) {
            if (isWidth) {  // 가로 검사
                if (arr[x][y + i] != arr[x][y + len - 1 - i]) {
                    return false;
                }
            } else {  // 세로 검사
                if (arr[x + i][y] != arr[x + len - 1 - i][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
