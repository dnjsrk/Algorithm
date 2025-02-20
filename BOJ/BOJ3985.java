import java.util.Scanner;

public class BOJ3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int n = sc.nextInt();

        int[] rollCake = new int[l];  // 롤케이크 배열

        int firstMax = 0;  // 가장 많은 조각을 받을 것으로 기대한 조각의 수
        int firstMaxUser = 0;  //가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호

        for (int i = 1; i <= n; i++) {
            int start = sc.nextInt();  // 왼쪽 조각
            int finish = sc.nextInt();  // 오른쪽 조각

            if (finish - start + 1 > firstMax) {  // 가장 많은 조각을 기대한 수와 방청객 번호를 구함
                firstMax = finish - start + 1;
                firstMaxUser = i;
            }

            for (int j = start - 1; j < finish; j++) {  // 방청객이 원하는 조각을 배열이 비어있다면 넣음
                if (rollCake[j] == 0) {
                    rollCake[j] = i;
                }
            }
        }

        int maxCnt = 0;  // 실제로 가장 많이 받은 조각
        int maxCntUser = 0;  // 실제로 가장 많은 조각을 받은 방청객의 번호

        for (int i = 1; i <= n; i++) {
            int cnt = 0;  // 조각의 수
            for (int j = 0; j < l; j++) {  // 방청객 1부터 조각의 수를 셈
                if (rollCake[j] == i)
                    cnt++;
            }

            if (cnt > maxCnt) {  // 센 조각의 수가 가장 크다면 실제로 가장 많은 조각과 방청객의 번호를 구함
                maxCnt = cnt;
                maxCntUser = i;
            }
        }

        System.out.println(firstMaxUser);
        System.out.println(maxCntUser);

    }
}
