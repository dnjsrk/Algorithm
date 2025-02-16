import java.util.Scanner;

public class SWEA5356 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            char[][] arr = new char[15][15];

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    arr[i][j] = '.';
                }
            }

            for (int i = 0; i < 5; i++) {
                String str = sc.next();
                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    if (arr[j][i] != '.') {
                        sb.append(arr[j][i]);
                    }
                }
            }

            System.out.println("#" + tc + " " + sb);
        }
    }
}
