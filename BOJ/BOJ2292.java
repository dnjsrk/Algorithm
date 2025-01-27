import java.util.Scanner;

public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int room = 1;  // 방의 수
        int range = 2;  // 범위

        for (int i = 2; i <= n; i++) {  // 입력한 숫자까지 반복
            if (i == range) {
                range = (room * 6) + range;  // 범위가 6씩 커짐
                room++;  // 방의 수 증가
            }
        }
        System.out.println(room);
    }
}
