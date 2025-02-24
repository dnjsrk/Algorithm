import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2606 {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = arr[b][a] = 1;
        }

        bfs(1);
        System.out.println(count);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[now][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
    }
}
