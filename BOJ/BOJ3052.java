import java.util.Scanner;

public class BOJ3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[10];
        int[] newNum = new int[10];

        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
            newNum[i] = num[i] % 42;  // 42로 나눈 나머지
        }


        int count = 0;
        for (int i = 0; i < 10; i++) {
            int cnt = 0;
            for (int j = i + 1; j < 10; j++) {
                if (newNum[i] != newNum[j]) {  // 값이 다르다면 cnt 증가
                    cnt++;
                }
            }
            if (cnt == 10 - i - 1) {  // cnt가 한줄의 길이라면 같은 값이 없다는 뜻이므로 count 증가
                count++;
            }
        }


        System.out.println(count);
    }
}
