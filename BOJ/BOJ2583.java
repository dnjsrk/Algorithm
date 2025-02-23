import java.util.*;

public class BOJ2583 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int m;
    static int n;
    static int k;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        map = new int[m][n];
        visited = new boolean[m][n];
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    map[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    int data = bfs(i, j);
                    list.add(data);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static int bfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] list = q.poll();
            int xx = list[0];
            int yy = list[1];

            for (int i = 0; i < 4; i++) {
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowX >= 0 && nowX < m && nowY>= 0 && nowY < n) {
                    if (!visited[nowX][nowY] && map[nowX][nowY] == 0) {
                        visited[nowX][nowY] = true;
                        q.add(new int[]{nowX, nowY});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
