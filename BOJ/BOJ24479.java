import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ24479 {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(R);
    }

    public static void dfs(int x) {
        visited[x] = true;
        System.out.println(x);
        for (int num : graph.get(x)) {
            if (!visited[num]) {
                dfs(num);
            }
        }
    }
}
