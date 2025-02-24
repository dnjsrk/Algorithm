import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ31575 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static String isOk = "No";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        bfs(0, 0);
        System.out.println(isOk);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == arr.length - 1 && nowY == arr[0].length - 1) {
                isOk = "Yes";
            }

            for (int i = 0; i < 2; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
