import java.util.Scanner;

public class SWEA4613 {
    static int N, M, minCnt;
    static int[][] flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            flag = new int[N][M];

            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < M; j++) {
                    flag[i][j] = str.charAt(j);
                }
            }

            minCnt = Integer.MAX_VALUE;

            int white = 0;
            for (int i = 0; i < N - 2; i++) {
                white += findColor('W', i);

                int blue = 0;
                for (int j = i + 1; j < N - 1; j++) {
                    blue += findColor('B', j);

                    int red = 0;
                    for (int k = j + 1; k < N; k++) {
                        red += findColor('R', k);
                    }

                    minCnt = Math.min(minCnt, white + blue + red);
                }
            }

            System.out.println("#" + tc + " " + minCnt);
        }
    }

    public static int findColor(char color, int r) {
        int cnt = 0;

        for (int c = 0; c < M; c++) {
            if (flag[r][c] != color) {
                cnt++;
            }
        }
        return cnt;
    }
}
