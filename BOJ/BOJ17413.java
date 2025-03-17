import java.util.Scanner;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();  // 띄어쓰기 포함 문장을 입력받기
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isOk = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);  // 문자

            if (c == '<') {  // '<'라면 스택에 있던 것들을 다 pop
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isOk = true;  // isOk를 true로 변경
                sb.append(c);
            } else if (c == '>') {  // '>'라면 isOk를 false로 변경하고 sb에 넣기
                isOk = false;
                sb.append(c);
            } else if (isOk == true) {  // isOk가 true일 때
                sb.append(c);  // sb에 넣기
            } else { // isOk가 false일 때
                if (c == ' ') {  // 공백이라면
                    while (!stack.isEmpty()) {  // 스택에 있던 것들을 다 pop
                        sb.append(stack.pop());
                    }
                    sb.append(' ');  // 공백도 넣어주기
                } else {
                    stack.push(c); // 스택에 넣기
                }
            }

        }

        while (!stack.isEmpty()) {  // 스택이 빌 때까지 pop하여 sb에 넣어주기
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
