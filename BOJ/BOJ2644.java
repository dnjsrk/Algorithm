import java.util.Scanner;

public class BOJ2644 {
    static int n, m, start, end;
    static int[][] graph;
    static int[] visitied;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();  // 전체 사람 수
        graph = new int[n + 1][n + 1];  // 인접 행렬
        visitied = new int[n + 1];  // 촌수 저장

        start = sc.nextInt();  // 촌수 시작
        end = sc.nextInt();  // 촌수 대상
        m = sc.nextInt();  // 관계 수

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(start);

        // 촌수를 계산하지 못하면 -1, 계산하면 visitied[end]
        System.out.println(visitied[end] == 0 ? -1 : visitied[end]);
    }

    public static void dfs(int s) {
        if (s == end) {  // 목표 노드에 도달하면 탐색하지 않음
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (graph[s][i] == 1 && visitied[i] == 0) {
                visitied[i] = visitied[s] + 1;  // 촌수는 이전 노드 촌수 + 1
                dfs(i);  // 재귀를 이용하여 촌수 계산
            }
        }
    }
}
