import java.util.Scanner;

public class BOJ1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N + 1];
        int num = 1;
        int cnt = 0;

        while (true) {
            arr[num]++;
            
            if (arr[num] == M) {
                break;
            } else if (arr[num] % 2 == 1) {
                num += L;
                if (num > N) {
                    num -= N;
                }
                cnt++;
            } else {
                num -= L;
                if (num <= 0) {
                    num += N;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
