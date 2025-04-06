import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ24479_DFS {
    static int N, M, R;
    static List<List<Integer>> graph;
    static int[] visited;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;

        dfs(R);

        for (int i = 1; i < graph.size(); i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);

    }

    public static void dfs(int n) {
        visited[n] = cnt;

        for (int i = 0; i < graph.get(n).size(); i++) {
            int newN = graph.get(n).get(i);

            if (visited[newN] == 0) {
                cnt++;
                dfs(newN);
            }
        }
    }
}
