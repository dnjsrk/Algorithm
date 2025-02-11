import java.util.Scanner;

public class SWEA2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // 테스트 케이스
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();  // 파리의 개수 n 배열
            int m = sc.nextInt();  // 파리채 크기 m 배열

            int[][] flyArr = new int[n][n];

            for (int i = 0; i < n; i++) {  // 파리의 개수 입력
                for (int j = 0; j < n; j++) {
                    flyArr[i][j] = sc.nextInt();
                }
            }

            int max = 0;  // 가장 많이 죽은 파리의 수

            for (int i = 0; i < n - m + 1; i++) {  // 배열의 값을 넘기면 안되므로 n - m + 1까지만 반복문을 돌림
                for (int j = 0; j < n - m + 1; j++) {
                    int sum = 0;  // 죽은 파리의 수를 더한 값
                    for (int a = i; a < i + m; a++) {  // 파리채의 크기만큼 반복문을 돌림
                        for (int b = j; b < j + m; b++) {
                            sum += flyArr[a][b];
                        }
                    }
                    if (sum >= max) {
                        max = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
