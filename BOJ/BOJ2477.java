import java.util.Scanner;

public class BOJ2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] directionArr = new int[6];  // 방향
        int[] lengthArr = new int[6];  // 길이

        for (int i = 0; i < 6; i++) {
            directionArr[i] = sc.nextInt();
            lengthArr[i] = sc.nextInt();
        }

        int maxWidth = 0, maxHeight = 0, minWidth = 0, minHeight = 0;

        for (int i = 0; i < 6; i++) {
            if (directionArr[i] == 1 || directionArr[i] == 2) {  // 가로 방향일 때
                if (lengthArr[i] > maxWidth) {  // 가장 긴 가로의 길이 구하기
                    maxWidth = lengthArr[i];
                    minHeight = lengthArr[(i + 3) % 6];  // '가장 긴 가로의 길이 + 3' 은 가장 짧은 세로의 길이
                }
            } else {
                if (lengthArr[i] > maxHeight) {  // 가장 긴 세로의 길이 구하기
                    maxHeight = lengthArr[i];
                    minWidth = lengthArr[(i + 3) % 6];  // '가장 긴 세로의 길이 + 3' 은 가장 짧은 가로의 길이
                }
            }
        }

        int maxSquare = maxWidth * maxHeight;  // 가장 큰 직사각형 넓이
        int minSquare = minWidth * minHeight;  // 참외밭이 아닌 직사각형의 넓이

        System.out.println((maxSquare - minSquare) * n);

    }
}
