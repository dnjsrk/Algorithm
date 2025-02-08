import java.util.Scanner;

public class BOJ2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] square = new int[100][100];  // 흰 도화지
        int n = sc.nextInt();  // 검정 색종이의 수

        for (int i = 0; i < n; i++) {
            int width = sc.nextInt();  // 가로
            int height = sc.nextInt();  // 세로

            for (int w = width; w < width + 10; w++) {  // 흰 도화지에 위치한 검정 도화지의 넓이만큼 배열을 1로 바꿔줌
                for (int h = height; h < height + 10; h++) {
                    square[w][h] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {  // 흰 도화지 배열의 값이 1이라면 cnt가 1 증가
            for (int j = 0; j < 100; j++) {
                if (square[i][j] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
