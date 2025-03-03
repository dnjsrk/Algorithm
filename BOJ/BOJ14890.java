import java.util.Scanner;

public class BOJ14890 {
    static int N;
    static int L;
    static int[][] arr;
    static boolean[][] visitied;
    static int pathCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        arr = new int[N][N];
        visitied = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            if (dfs(i, 0, true)) {
                pathCnt++;
            }
            if (dfs(0, i, false)) {
                pathCnt++;
            }
        }

        System.out.println(pathCnt);
    }

    public static boolean dfs(int x, int y, boolean flag) {
        int[] height = new int[N];
        boolean[] visited =  new boolean[N];

        for (int i = 0; i < N; i++) {
            if (flag) {
                height[i] = arr[x][i];
            } else {
                height[i] = arr[i][y];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            if (height[i] == height[i + 1]) {
                continue;
            } else if (height[i] - height[i + 1] == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || height[i + 1] != height[j] || visited[j]) {
                        return false;
                    } else {
                        visited[j] = true;
                    }
                }
            } else if (height[i] - height[i + 1] == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j]) {
                        return false;
                    } else {
                        visited[j] = true;
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }

}
