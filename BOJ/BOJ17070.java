import java.util.Scanner;

public class BOJ17070 {
    static int n, cnt;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int state) {
        if (x == n - 1 && y == n - 1) {
            cnt++;
        }

        if (state == 0) {
            if (y + 1 < n && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
        } else if (state == 1) {
                if (x + 1 < n && arr[x + 1][y] == 0) {
                    dfs(x + 1, y, 1);
                }
        } else if (state == 2) {
            if (y + 1 < n && arr[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }

            if (x + 1 < n && arr[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }

        }

        if (x + 1 < n && y + 1 < n && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }

    }
}
