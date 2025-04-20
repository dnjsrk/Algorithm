import java.util.*;

public class BOJ1260 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int v = sc.nextInt();

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v);
        System.out.println();
        visited = new boolean[1001];
        bfs(v);
    }

    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for (int num : graph.get(x)) {
            if (! visited[num]) {
                dfs(num);
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int value = queue.poll();
            System.out.print(value + " ");

            for (int num : graph.get(value)) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }
    }
}
