import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {  // 큐에 1~n까지의 사람 넣기
            queue.add(i);
        }

        sb.append("<");

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {  // k-1까지 큐의 앞 요소를 제거한 뒤 큐에 추가한다.
                int num = queue.poll();
                queue.offer(num);
            }

            sb.append(queue.poll()).append(", ");  // 큐의 k번째 요소를 제거 후 sb에 넣기
        }

        sb.append(queue.poll()).append(">");  // 마지막 남은 요소를 제거 후 sb에 넣기

        System.out.println(sb);
    }
}
