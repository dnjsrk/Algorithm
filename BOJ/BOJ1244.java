import java.util.Scanner;

public class BOJ1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 스위치 개수
        int[] switchArr = new int[n];
        for (int i = 0; i < n; i++) {
            switchArr[i] = sc.nextInt();  // 스위치 상태
        }
        
        int student = sc.nextInt();  // 학생 수
        for (int i = 0; i < student; i++) {  // 학생 수 만큼 반복
            int sex = sc.nextInt();  // 성별
            int num = sc.nextInt();  // 번호
            
            if (sex == 1) {  // 남자라면
                for (int j = 0; j < n; j++) {
                    if ((j + 1) % num == 0) {  // 스위치의 번호는 1부터 시작하므로 j + 1이 num의 배수이면
                        switchArr[j] = (switchArr[j] == 0) ? 1 : 0;  // 스위치 바꾸기
                    }
                }
                
            } else if (sex == 2) {  // 여자라면
                switchArr[num - 1] = (switchArr[num - 1] == 0) ? 1 : 0;  // num에 해당하는 스위치 바꾸기
                for (int j = 1; j < n; j++) {
                    if ((num - 1 - j >= 0) && (num - 1 + j < n)) {  // 스위치의 좌우가 배열의 크기에 맞는지 확인
                        if (switchArr[num - 1 - j] == switchArr[num - 1 + j]) {  // 좌우가 대칭이라면
                            switchArr[num - 1 - j] = (switchArr[num - 1 - j] == 0) ? 1 : 0;  //스위치 바꾸기
                            switchArr[num - 1 + j] = (switchArr[num - 1 + j] == 0) ? 1 : 0;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(switchArr[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
