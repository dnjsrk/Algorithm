import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA4012 {
    static int n, size, minTaste;
    static int[][] arr;
    static List<List<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            minTaste = Integer.MAX_VALUE;
            size = n / 2;
            list = new ArrayList<>();

            makeList(0, new ArrayList<>());

            System.out.println("#" + tc + " " + minTaste);
        }
    }

    public static void makeList(int start, List<Integer> current) {
        if (current.size() == size) {  // n / 2개의 재료가 선택되면
            List<Integer> anotherList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (!current.contains(i)) {  // current에 없는 값을 anotherList에 넣음
                    anotherList.add(i);
                }
            }

            int taste1 = getTaste(current);  // 첫번째 시너지 합
            int taste2 = getTaste(anotherList);  // 두번째 시너지 합
            int taste = Math.abs(taste1 - taste2);  // 시너지 차이

            minTaste = Math.min(minTaste, taste);  // 가장 작은 시너지를 찾음
            return;
        }

        for (int i = start; i < n; i++) {
            current.add(i);
            makeList(i + 1, current);
            current.remove(current.size() - 1);
        }
    }


    public static int getTaste(List<Integer> tasteList) {
        int sum = 0;  // 시너지 합

        for (int i = 0; i < tasteList.size() - 1; i++) {
            for (int j = i + 1; j < tasteList.size(); j++) {
                sum += arr[tasteList.get(i)][tasteList.get(j)];
                sum += arr[tasteList.get(j)][tasteList.get(i)];
            }
        }

        return sum;
    }
}

