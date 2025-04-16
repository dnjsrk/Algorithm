import java.util.Scanner;

public class BOJ14938 {
    public static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 지역 수
        int m = sc.nextInt();  // 수색 범위
        int r = sc.nextInt();  // 길의 수

        int[] item = new int[n + 1];  // 각 지역의 아이템 수
        for (int i = 1; i <= n; i++) {
            item[i] = sc.nextInt();
        }

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;  // 자기 자신은 거리 0

                arr[i][j] = INF;  // INF로 초기화
            }
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();  // 시작 지역
            int b = sc.nextInt();  // 도착 지역
            int l = sc.nextInt();  // 거리

            // 양방향
            arr[a][b] = l;
            arr[b][a] = l;
        }

        // 플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                   // i -> j로 가는 경로 중, k를 거치는 경로가 더 짧다면 갱신
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = 0;  // 최대로 얻을 수 있는 아이템 수
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] <= m) {  // 수색범위가 m 이내면 아이템 더함
                    cnt += item[j];
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
