import java.util.Scanner;

public class SWEA21936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String str = sc.next();

            StringBuilder sb = new StringBuilder();
            boolean isOk = false;

            for (int i = 0; i < n - m + 1; i++) {
                String sub = str.substring(i, i + m);
                if (isPalindrome(sub)) {
                    sb.append(sub);
                    isOk = true;
                }
            }

            System.out.print("#" + tc + " ");
            if (isOk) {
                System.out.print(sb);
            } else {
                System.out.print("None");
            }
            System.out.println();
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
