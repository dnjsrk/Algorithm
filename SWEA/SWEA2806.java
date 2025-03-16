import java.util.Scanner;

public class SWEA2806 {
    static int N, cnt;
    static int[] queens;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            N = sc.nextInt();
            cnt = 0;
            queens = new int[N];

            solveNQueen(0);

            System.out.println("#" + tc + " " + cnt);
        }
    }

    static void solveNQueen(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;
                solveNQueen(row + 1);
            }
        }
    }

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
