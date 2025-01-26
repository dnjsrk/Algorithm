import java.util.Scanner;

//"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
//문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
//"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.

public class BOJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;  //연속된 개수
            int sum = 0;  //점수

            for (int j = 0; j < arr[i].length(); j++) {  //퀴즈의 길이
                if (arr[i].charAt(j) == 'O') {  //퀴즈의 해당 인덱스의 값이 'O'라면
                    cnt += 1;  //연속된 개수에 1을 더함
                    sum += cnt;  //점수에 연속된 개수를 더함
                } else {
                    cnt = 0;  //'O'가 아니라면 연속된 개수를 0으로 초기화
                }
            }
            System.out.println(sum);
        }

    }
}
