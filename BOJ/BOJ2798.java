import java.util.Scanner;

public class BOJ2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 카드의 수
        int m = sc.nextInt(); // 딜러가 부른 값
        int[] cardArr = new int[n];

        for (int i = 0; i < n ; i++) {  // 카드의 수만큼 숫자 입력
            cardArr[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int cardSum = cardArr[i] + cardArr[j] + cardArr[k];
                    if (cardSum > max && cardSum <= m) {  // m을 넘지 않으면서 최대값보다 크다면 max를 갱신
                        max = cardSum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
