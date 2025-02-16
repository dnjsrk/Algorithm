import java.util.Scanner;

public class SWEA4613 {
    static int n;
    static int m;
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            int min = Integer.MAX_VALUE;

            int w = 0;
            for (int i = 1; i < n - 2; i++) {
                w += colorCnt('W', i);

                int b = 0;
                for (int j = i + 1; j < n - 1; j++) {
                    b += colorCnt('B', j);

                    int r = 0;
                    for (int k = j + 1; k < n; k++) {
                        r += colorCnt('R', k);
                    }

                    min = Math.min(min, w + b + r);
                }
            }


            System.out.println("#" + tc + " " + min);
        }
    }

    private static int colorCnt(char color, int x) {
        int cnt = 0;
        for (int y = 0; y < m; y++) {
            if (arr[x][y] != color) {
                cnt++;
            }
        }
        return cnt;
    }
}
