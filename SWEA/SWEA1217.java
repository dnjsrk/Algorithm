import java.util.Scanner;

public class SWEA1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();

            int n = sc.nextInt();
            int m = sc.nextInt();
        }
    }

    public static int pow(int n, int m) {
        if (m == 1) {
            return n;
        }

        if (m % 2 == 0) {
            int tmp = pow(n, m / 2);
            return tmp * tmp;
        } else {
            int tmp = pow(n, (m - 1) / 2);
            return tmp * tmp * n;
        }
    }
}
