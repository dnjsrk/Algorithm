import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];  // 배열에 수를 입력받고 입력받은 수를 sum에 더함
        }

        int height = sum - 100;  // 입력받은 수를 다 더한 값에 난쟁이의 합인 100을 뺌

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == height) {  // arr[i]와 arr[j]의 합이 height와 같다면 0으로 초기화하고 오름차순 정렬
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);

                    for (int k = 2; k < arr.length; k++) {  // 0을 제외한 arr[2]부터 출력
                        System.out.println(arr[k]);
                    }

                    return;
                }
            }
        }
    }
}
