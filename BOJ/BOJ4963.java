import java.util.Scanner;

public class BOJ4963 {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
