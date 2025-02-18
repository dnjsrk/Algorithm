import java.util.Scanner;

public class BOJ2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        int[] arr = new int[n]; // 10개의 버섯 점수를 담는 배열

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();  // 버섯 점수 입력
        }

        int sum = 0; // 점수의 합
        int prevSum = 0; // 이전 합

        for (int i = 0; i < n; i++) {
            prevSum = sum; // 현재 합을 이전 합으로 저장
            sum += arr[i]; // 현재 버섯 점수 더하기

            if (sum >= 100) { // 합이 100보다 크거나 같으면
                int smallDiff = Math.abs(100 - prevSum); // 이전 합과 100의 차이
                int bigDiff = Math.abs(100 - sum); // 현재 합과 100의 차이

                if (bigDiff > smallDiff) { // 이전 합이 100에 더 가깝다면 현재 합을 이전 합으로 저장
                    sum = prevSum;
                }
                break;
            }
        }

        System.out.println(sum);
    }
}
