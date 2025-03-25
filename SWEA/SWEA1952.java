import java.util.Scanner;

public class SWEA1952 {
    static int minCost;
    static int[] cost, plan;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            cost = new int[4];
            plan = new int[13];

            for (int i = 0; i < 4; i++) {
                cost[i] = sc.nextInt();
            }

            for (int i = 1; i <= 12; i++) {
                plan[i] = sc.nextInt();
            }

            minCost = cost[3];

            dfs(1, 0);

            System.out.println("#" + tc + " " + minCost);
        }
    }

    public static void dfs(int month, int sum) {
        if (month > 12) {
            minCost = Math.min(minCost, sum);
            return;
        }

        if (plan[month] == 0) {
            dfs(month + 1, sum);
        } else {
            dfs(month + 1, sum + cost[0] * plan[month]);
            dfs(month + 1, sum + cost[1]);
            dfs(month + 3, sum + cost[2]);
        }
    }
}
