import java.util.Scanner;

public class SWEA2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();  // 테스트 케이스
		for (int tc = 1; tc <= t; tc++) {
			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {  // 배열의 크기만큼 숫자를 입력받음
				arr[i] = sc.nextInt();
			}
			
			int max = 0;  // 최댓값을 0으로 둔다
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max) {  // arr[i]가 max보다 크다면 max는 arr[i]
					max = arr[i];
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
