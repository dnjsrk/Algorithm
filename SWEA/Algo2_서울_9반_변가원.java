import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Algo2_서울_9반_변가원 {
    static int N, M, K;
    static int[][] chess;
    static int rookX, rookY, knightX, knightY;
    static int[] rookDx = {1, -1, 0, 0};
    static int[] rookDy = {0, 0, 1, -1};
    static int[] knightDx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] knightDy = {1, 2, 2, 1, -1, -2, -2, -1};
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            chess = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    chess[i][j] = sc.nextInt();
                }
            }

            // 룩과 나이트 위치 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (chess[i][j] == 1) {
                        rookX = i;
                        rookY = j;
                    } else if (chess[i][j] == 2) {
                        knightX = i;
                        knightY = j;
                    }
                }
            }

            result.clear();
            moveChess(rookX, rookY, knightX, knightY, 0);
            System.out.println("#" + tc + " " + result.size());

        }
    }

    static void moveChess(int rx, int ry, int kx, int ky, int move) {
        if (move == K) { // K번 이동을 마친 경우 현재 위치 상태를 Set에 저장
            result.add(rx + "," + ry + "," + kx + "," + ky);
            return;
        }

        for (int i = 0; i < 4; i++) {  // 룩
            int x = rx;
            int y = ry;

            while (true) {
                x += rookDx[i];
                y += rookDy[i];

                // 체스판을 벗어나면 중단
                if (!(x >= 0 && x < N && y >= 0 && y < M)) {
                    break;
                }

                // 나이트가 있는 위치로는 이동 불가
                if (x == kx && y == ky) {
                    break;
                }

                moveChess(x, y, kx, ky, move + 1);
            }
        }

        for (int i = 0; i < 8; i++) {  // 나이트
            int x = kx + knightDx[i];
            int y = ky + knightDy[i];

            if (!(x >= 0 && x < N && y >= 0 && y < M)) {
                continue;
            }

            if (x == rx && y == ry) {
                continue;
            }

            moveChess(rx, ry, x, y, move + 1);
        }
    }
}
