import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 10;  // 테스트 케이스
        for (int tc = 1; tc <= t; tc++) {
            int n = 100;  // 가로의 길이
            int[] boxArr = new int[n];
            int dump = sc.nextInt();  // 덤프 횟수

            for (int i = 0; i < n; i++) {  // 가로의 길이만큼 상자의 높이 입력
                boxArr[i] = sc.nextInt();
            }

            for (int i = 0; i < dump; i++) {
                int max = boxArr[0];  // 가장 높은 높이
                int maxIndex = 0;
                int min = boxArr[0];  // 가장 낮은 높이
                int minIndex = 0;

                for (int j = 1; j < n; j++) {  // 가장 높은 높이와 낮은 높이 구하기
                    if (boxArr[j] > max) {
                        max = boxArr[j];
                        maxIndex = j;
                    }

                    if (boxArr[j] < min) {
                        min = boxArr[j];
                        minIndex = j;
                    }
                }

                boxArr[maxIndex]--;  // 가장 높은 층에서 한 층을 뺌
                boxArr[minIndex]++;  // 가장 낮은 층에서 한 층을 더함
            }

            Arrays.sort(boxArr);  // 상자 배열을 정렬
            int height = boxArr[n - 1] - boxArr[0];  // 가장 높은 층과 낮은 층의 높이를 구함

            System.out.println("#" + tc + " " + height);
        }

    }
}