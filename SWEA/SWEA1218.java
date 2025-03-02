import java.util.Scanner;
import java.util.Stack;

public class SWEA1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            Stack<Character> stack = new Stack<>();
            int n = sc.nextInt();
            String str = sc.next();
            boolean isOk = true;

            for (int i = 0; i < n; i++) {
                char a = str.charAt(i);

                if (a == '(' || a == '[' || a == '{' || a == '<') {
                    stack.push(a);
                } else if (a == ')') {
                    if (stack.pop() != '(') {
                        isOk = false;
                        break;
                    }
                } else if (a == ']') {
                    if (stack.pop() != '[') {
                        isOk = false;
                        break;
                    }
                } else if (a == '}') {
                    if (stack.pop() != '{') {
                        isOk = false;
                        break;
                    }
                } else if (a == '>') {
                    if (stack.pop() != '<') {
                        isOk = false;
                        break;
                    }
                }
            }

            System.out.print("#" + tc + " ");
            if (isOk == false) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }

        }
    }
}
