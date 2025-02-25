import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;  // 봉지의 수

        while (n > 0) {
            if (n % 5 == 0) {  // 5로 나누어지면
                count += n / 5;  // 나눈 값을 더하고 종료
                break;
            } else {
                n -= 3;  // 3씩 빼준 뒤 카운트 1씩 추가
                count++;
            }

            if (n < 0) {  // 3과 5로 나누어지지 않으면 -1
                count = -1;
            }
        }

        System.out.println(count);
    }
}
