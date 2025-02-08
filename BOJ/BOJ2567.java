import java.util.Scanner;

public class BOJ2567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] square = new int[100][100];  // 흰 도화지
        int n = sc.nextInt();  // 검정 색종이의 수

        for (int i = 0; i < n; i++) {
            int width = sc.nextInt();  // 가로
            int height = sc.nextInt(); // 세로

            for (int w = width; w < width + 10; w++) {  // 흰 도화지에 위치한 검정 도화지 부분을 1로 바꿔줌
                for (int h = height; h < height + 10; h++) {
                    square[w][h] = 1;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};  // 상하좌우
        int[] dy = {0, 0, 1, -1};

        int cnt = 0;  // 둘레 길이

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (square[i][j] == 1) {  // 검은색 영역만 탐색
                    for (int k = 0; k < 4; k++) {
                        int heightY = i + dy[k];  // 세로
                        int widthX = j + dx[k];  // 가로

                        // 도화지 범위를 벗어나거나 흰 영역과 닿아있으면 둘레에 1 더함
                        if (heightY < 0 || heightY >= 100 || widthX < 0 || widthX >= 100 || square[heightY][widthX] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
