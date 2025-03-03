import java.util.Scanner;

public class SWEA4014 {
    static int n, x, pathCnt;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            x = sc.nextInt();
            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            pathCnt = 0;

            for (int i = 0; i < n; i++) {
                if (checkPath(i, true)) { 
                    pathCnt++;
                }
                if (checkPath(i, false)) {
                    pathCnt++;
                }
            }

            System.out.println("#" + tc + " " + pathCnt);
        }
    }

    public static boolean checkPath(int idx, boolean isRow) {
        int[] height = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isRow) {
                height[i] = arr[idx][i];
            } else {
                height[i] = arr[i][idx];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (height[i] == height[i + 1]) {
            } else if (height[i] - height[i + 1] == 1) {
                for (int j = i + 1; j <= i + x; j++) {
                    if (j >= n || height[i + 1] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if (height[i] - height[i + 1] == -1) {
                for (int j = i; j > i - x; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
