import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
    int x;
    int y;
    int z;

    Tomato(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }
}
public class BOJ7569 {
    static int M, N, H;
    static int[][][] tomato;
    static Queue<Tomato> queue;

    static int[] dx = { -1, 0, 1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        tomato = new int[H][M][N];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    tomato[i][j][k] = sc.nextInt();

                    if (tomato[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Tomato tomatoq = queue.poll();

            int z = tomatoq.z;
            int y = tomatoq.y;
            int x = tomatoq.x;

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int nz = z + dz[d];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                    if (tomato[nz][ny][nx] == 0) {
                        queue.offer(new Tomato(nz, ny, nx));
                        tomato[nz][ny][nx] = tomato[z][y][x] + 1;
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (tomato[i][j][k] == 0) return -1;
                    ans = Math.max(ans, tomato[i][j][k]);
                }
            }
        }

        if (ans == 1) {
            return 0;
        } else {
            return ans - 1;
        }
    }
}
