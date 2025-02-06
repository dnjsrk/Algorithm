import java.util.Scanner;

public class SWEA1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = 10;  // 테스트 케이스
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();  // 건물의 개수
			int[] buildingArr = new int[n];  // 건물 배열
			int sum = 0; // 조망권이 확보된 세대의 수
			
			for (int i = 0; i < n; i++) {
				buildingArr[i] = sc.nextInt();  // 건물의 높이 입력
			}
			
			for (int i = 2; i < n - 2; i++) {
				int left1 = buildingArr[i] - buildingArr[i - 1];  // 왼쪽 거리 1
				int left2 = buildingArr[i] - buildingArr[i - 2];  // 왼쪽 거리 2
				int right1 = buildingArr[i] - buildingArr[i + 1];  // 오른쪽 거리 1
				int right2 = buildingArr[i] - buildingArr[i + 2];  // 오른쪽 거리 2
				
				if (left1 > 0 && left2 > 0 && right1 > 0 && right2 > 0) {  // 조망권이 확보가 된다면
					int left = (left1 > left2 ? left2 : left1);  // 더 작은 왼쪽 거리 구하기
					int right = (right1 > right2 ? right2 : right1);  // 더 작은 오른쪽 거리 구하기
					
					if (left >= right) {  // 왼쪽과 오른쪽 거리 중에서 작은 거리를 sum에 더하기
						sum += right;
					} else {
						sum += left;
					}
				}
				
			}
			System.out.println("#" + (tc+1) + " " + sum);
		}
	}
}
