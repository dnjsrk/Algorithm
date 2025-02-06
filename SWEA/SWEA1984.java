import java.util.Scanner;

public class SWEA1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();  // 테스트 케이스
		for (int tc = 1; tc <= t; tc++) {
			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {  // 배열의 크기만큼 숫자를 입력받음
				arr[i] = sc.nextInt();
			}
			
			int min = arr[0];
			int max = arr[0];
			
			for (int i = 1; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
				}
				
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != min && arr[i] != max) {
					sum += arr[i];
					cnt++;
				}
			}
			
			int avg = Math.(sum / cnt);
			System.out.println("#" + tc + " " + avg);
		}
	}
}
