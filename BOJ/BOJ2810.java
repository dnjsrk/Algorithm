import java.util.Scanner;

//극장의 한 줄의 정보가 주어지고 이 줄에 사람들이 모두 앉았을 때, 컵홀더에 컵을 꽂을 수 있는 최대 사람의 수를 구하기.
// 모든 사람은 컵을 한 개만 들고 있고, 자신의 좌석의 양 옆에 있는 컵홀더에만 컵을 꽂을 수 있다.
//S는 일반 좌석, L은 커플석을 의미하며, L은 항상 두개씩 쌍으로 주어진다.

public class BOJ2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String seats = sc.next();

        int i = 0;
        int cup = 1;  // 가장 왼쪽의 컵홀더

        while (i < n) {
            if (seats.charAt(i) == 'L') {  //'L'은 항상 쌍이므로 i를 2씩 더함
                cup += 1;
                i += 2;
            } else if (seats.charAt(i) == 'S') {
                cup += 1;
                i += 1;
            }
        }
        System.out.println(Math.min(n, cup));  //좌석 수와 컵홀더를 꽂을 수 있는 최대 사람 중 작은 값 출력

    }
}
