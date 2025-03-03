import java.util.*;

class Microbe {
    int x, y, num, dir;

    public Microbe(int x, int y, int num, int dir) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.dir = dir;
    }
}

public class SWEA2382 {
    static int N, M, K;
    static int[] dx = {0, -1, 1, 0, 0}; // 상(1), 하(2), 좌(3), 우(4)
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            N = sc.nextInt();  // 전역 변수로 업데이트
            M = sc.nextInt();
            K = sc.nextInt();

            List<Microbe> microbes = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int num = sc.nextInt();
                int dir = sc.nextInt();
                microbes.add(new Microbe(x, y, num, dir));
            }

            for (int i = 0; i < M; i++) {
                moveMicrobes(microbes);
            }

            int cnt = 0;
            for (Microbe micro : microbes) {
                cnt += micro.num;
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }

    static void moveMicrobes(List<Microbe> microbes) {
        Microbe[][] arr = new Microbe[N][N];

        for (Microbe m : microbes) {
            int nx = m.x + dx[m.dir];
            int ny = m.y + dy[m.dir];

            if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
                m.num /= 2;
                if (m.num == 0) continue;

                if (m.dir == 1) m.dir = 2;
                else if (m.dir == 2) m.dir = 1;
                else if (m.dir == 3) m.dir = 4;
                else if (m.dir == 4) m.dir = 3;
            }

            if (arr[nx][ny] == null) {
                arr[nx][ny] = new Microbe(nx, ny, m.num, m.dir);
            } else {
                Microbe exist = arr[nx][ny];
                if (exist.num < m.num) {
                    exist.dir = m.dir;
                }
                exist.num += m.num;
            }
        }

        microbes.clear();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != null) {
                    microbes.add(arr[i][j]);
                }
            }
        }
    }
}
