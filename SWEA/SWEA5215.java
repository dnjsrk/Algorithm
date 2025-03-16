import java.util.Scanner;

public class SWEA5215 {
    static int N, L, maxScore;
    static int[] score;
    static int[] kcal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();

            score = new int[N];
            kcal = new int[N];

            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                kcal[i] = sc.nextInt();
            }

            maxScore = 0;

            hamburger(0, 0, 0);
            System.out.println("#" + tc + " " + maxScore);
        }
    }

    public static void hamburger(int idx, int s, int k) {
        if(k > L) {
            return;
        }

        if (idx == N) {
            if (s > maxScore) {
                maxScore = s;
            }
            return;
        }

        hamburger(idx + 1, s + score[idx], k + kcal[idx]);
        hamburger(idx + 1, s, k);
    }
}
