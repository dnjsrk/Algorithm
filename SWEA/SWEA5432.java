import java.util.Scanner;
import java.util.Stack;

public class SWEA5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            String str = sc.next();

            Stack<Character> stack = new Stack<>();

            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else {
                    stack.pop();
                    if (str.charAt(i - 1) == '(') {
                        cnt += stack.size();
                    } else {
                        cnt++;
                    }
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }
}
