import java.util.Scanner;

public class SWEA1949 {
    static int n, k, high, max;
    static int[][] arr;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            k = sc.nextInt();
            high = 0;
            max = 0;

            arr = new int[n + 1][n + 1];
            visit = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = sc.nextInt();
                    high = Math.max(high, arr[i][j]);
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] == high) {
                        visit[i][j] = 1;
                        dfs(i, j, 1, 1);
                        visit[i][j] = 0;
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    public static void dfs(int x, int y, int count, int cut) {
        int cur = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;

            int next = arr[nx][ny];

            if (visit[nx][ny] == 0) {
                if (next < cur) {
                    visit[nx][ny] = 1;
                    dfs(nx, ny, count + 1, cut);
                    visit[nx][ny] = 0;
                } else if (cut == 1) {
                    for (int j = 1; j <= k; j++) {
                        if ((next - j) < cur) {
                            arr[nx][ny] -= j;
                            dfs(nx, ny, count + 1, cut - 1);
                            arr[nx][ny] += j;
                        }
                    }
                }
            }
        }

        max = Math.max(max, count);
    }
}
