import java.util.Scanner;

public class SWEA1954 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();

            int[][] arr = new int[n][n];

            int dir = 0;
            int x = 0, y = 0;

            for (int i = 1; i <= n * n; i++) {
                arr[x][y] = i;

                if (x + dx[dir] < 0 || x + dx[dir] >= n || y + dy[dir] < 0 || y + dy[dir] >= n || arr[x + dx[dir]][y + dy[dir]] != 0) {
                    dir = (dir + 1) % 4;
                }

                x += dx[dir];
                y += dy[dir];
            }

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
