package mid;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 배열 크기
            int M = sc.nextInt(); // 스프레이 세기

            int[][] grid = new int[N][N];

            // 배열 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int maxFlies = 0;

            // 모든 칸을 중심으로 +와 x 모양으로 파리 잡기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxFlies = Math.max(maxFlies, getPlusFlies(grid, N, M, i, j));
                    maxFlies = Math.max(maxFlies, getXFlies(grid, N, M, i, j));
                }
            }

            System.out.println("#" + t + " " + maxFlies);
        }

        sc.close();
    }

    // + 형태로 잡은 파리 수 계산
    private static int getPlusFlies(int[][] grid, int N, int M, int x, int y) {
        int flies = grid[x][y];

        // 상, 하, 좌, 우 방향으로 M-1 칸씩
        for (int d = 1; d < M; d++) {
            if (x - d >= 0) flies += grid[x - d][y];
            if (x + d < N) flies += grid[x + d][y];
            if (y - d >= 0) flies += grid[x][y - d];
            if (y + d < N) flies += grid[x][y + d];
        }

        return flies;
    }

    // x 형태로 잡은 파리 수 계산
    private static int getXFlies(int[][] grid, int N, int M, int x, int y) {
        int flies = grid[x][y];

        // 대각선 방향으로 M-1 칸씩
        for (int d = 1; d < M; d++) {
            if (x - d >= 0 && y - d >= 0) flies += grid[x - d][y - d];
            if (x - d >= 0 && y + d < N) flies += grid[x - d][y + d];
            if (x + d < N && y - d >= 0) flies += grid[x + d][y - d];
            if (x + d < N && y + d < N) flies += grid[x + d][y + d];
        }

        return flies;
    }
}
