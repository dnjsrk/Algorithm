import java.util.Scanner;

public class SWEA1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {  // 테스트 케이스의 수
            int num = sc.nextInt();  // 테스트 케이스 번호
            int n = 1000;  // 학생 수
            int[] scoreArr = new int[n];  // 점수 배열

            for (int i = 0; i < n; i++) {  // 점수를 입력 받음
                scoreArr[i] = sc.nextInt();
            }

            int[] cntArr = new int[101];
            for (int i = 0; i < n; i++) {  // 점수를 인덱스로 생각하여 해당하는 cntArr 인덱스의 값이 1씩 증가
                cntArr[scoreArr[i]]++;
            }

            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < 101; i++) {
                if (cntArr[i] >= max) {  // 가장 큰 수와 그에 해당하는 인덱스 찾기
                    max = cntArr[i];
                    maxIndex = i;
                }
            }
            System.out.println("#" + num + " " + maxIndex);
        }
    }
}
