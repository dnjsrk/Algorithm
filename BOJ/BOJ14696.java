import java.util.Scanner;

public class BOJ14696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 라운드 수
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();  // A 딱지의 그림 수
            int[] aCard = new int[5];

            for (int j = 0; j < a; j++) {  // 해당하는 딱지그림 1 증가
                int temp = sc.nextInt();
                aCard[temp]++;
            }

            int b = sc.nextInt();  // B 딱지의 그림 수
            int[] bCard = new int[5];

            for (int j = 0; j < b; j++) {  // 해당하는 딱지그림 1 증가
                int temp = sc.nextInt();
                bCard[temp]++;
            }

            if (aCard[4] != bCard[4]) {  // 별의 수가 다를 때
                System.out.println(aCard[4] > bCard[4] ? 'A' : 'B');
            } else {
                if (aCard[3] != bCard[3]) {  // 동그라미의 수가 다를 때
                    System.out.println(aCard[3] > bCard[3] ? 'A' : 'B');
                } else {
                    if (aCard[2] != bCard[2]) {  // 네모의 수가 다를 때
                        System.out.println(aCard[2] > bCard[2] ? 'A' : 'B');
                    } else {
                        if (aCard[1] != bCard[1]) {  // 세모의 수가 다를 때
                            System.out.println(aCard[1] > bCard[1] ? 'A' : 'B');
                        } else {
                            System.out.println("D");  // 무승부일 때
                        }
                    }
                }
            }
        }
    }
}
