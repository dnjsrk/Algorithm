import java.util.Scanner;

//변의 길이가 1인 정사각형 n개를 이용해서 만들 수 있는 직사각형의 개수 구하기
//두 직사각형 A와 B가 있을 때, A를 이동, 회전시켜서 B를 만들 수 없으면, 두 직사각형은 다름.
//직사각형을 만들 때, 정사각형을 변형시키거나, 한 정사각형 위에 다른 정사각형을 놓을 수 없다.
//직사각형은 정사각형으로 꽉 차있어야 한다.

public class BOJ8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        for (int i = 1; i <= n; i++) {  //a * b 와 b * a는 같기 때문에 반복문을 j는 i의 길이까지만 돌림
            for (int j = 1; j <= i; j++) {
                if (i * j <= n) {  //n보다 작거나 같으면 됨
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
