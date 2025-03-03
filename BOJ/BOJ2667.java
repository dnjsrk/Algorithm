import java.util.Arrays;
import java.util.Scanner;

public class BOJ2667 {
    static int n, apartNum;
    static int[][] arr;
    static boolean[][] visited;
    static int[] apart;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        apart = new int[n * n];

        for (int i= 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(apart);
        System.out.println(apartNum);

        for (int i = 0; i < apart.length; i++) {
            if (apart[i] != 0) {
                System.out.println(apart[i]);
            }
        }


    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        apart[apartNum]++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
