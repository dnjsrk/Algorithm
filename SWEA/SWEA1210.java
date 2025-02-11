import java.util.Scanner;

public class SWEA1210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {  // 테스트 10번
            int tc = sc.nextInt();  // 테스트 케이스
            int n = 100;
            int[][] ladderArr = new int[n][n];  // 사다리 배열

            for (int i = 0; i < n; i++) {  // 사다리 배열에 숫자를 입력
                for (int j = 0; j < n; j++) {
                    ladderArr[i][j] = sc.nextInt();
                }
            }

            int finishI = 0;
            for (int i = 0; i < n; i++) {  // 2인 도착점을 찾음
                if (ladderArr[n - 1][i] == 2) {
                    finishI = i;
                }
            }

            for (int i = n - 1; i >= 0; i--) {  // 도착점에서부터 위로 시작점을 찾음
                int cnt = 0;
                while (finishI > 0) {
                    if (ladderArr[i][finishI - 1] == 1) {  // 현재 위치에서 왼쪽이 1이라면 행을 1줄이고 카운트를 1추가한다
                        finishI--;
                        cnt++;
                    } else {
                        break;
                    }
                }

                if (cnt == 0) {  // 왼쪽으로 가지 않았다면
                    while (finishI < n - 1) {
                        if (ladderArr[i][finishI + 1] == 1) {  // 오른쪽 방향이 1인지 확인
                            finishI++;
                        } else {
                            break;
                        }
                    }
                }
            }


            System.out.println("#" + tc + " " + finishI);
        }
    }
}
