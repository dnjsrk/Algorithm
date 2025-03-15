import java.util.Scanner;

public class BOJ13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 학생 수
        int k = sc.nextInt();  // 방 배정 최대 인원 수

        int[][] student = new int[2][7];  // 각 성별 별 학년의 수를 담는 배열

        for (int i = 0; i < n; i++) {  // 해당하는 배열 1씩 추가
            int s = sc.nextInt();
            int y = sc.nextInt();

            student[s][y]++;
        }

        int room = 0;  // 방의 수

        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student[i].length; j++) {
                room += student[i][j] / k;  // k로 나눈 값을 더함

                if (student[i][j] % k != 0) {  // 나머지가 있다면 1 추가
                    room += 1;
                }
            }
        }

        System.out.println(room);
    }
}
