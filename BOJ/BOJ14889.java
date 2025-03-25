import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ14889 {
    static int N, minAbility;
    static int[][] arr;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        minAbility = Integer.MAX_VALUE;
        arr = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        makeList(0, list);
        System.out.println(minAbility);

    }

    public static void makeList(int start, List<Integer> current) {
        if (current.size() == N / 2) {
            List<Integer> anotherList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (!current.contains(i)) {
                    anotherList.add(i);
                }
            }

            int ability1 = getAbility(current);
            int ability2 = getAbility(anotherList);
            int ability = Math.abs(ability1 - ability2);

            minAbility = Math.min(minAbility, ability);
        }

        for (int i = start; i < N; i++) {
            current.add(i);
            makeList(i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    public static int getAbility(List<Integer> abilityList) {
        int sum = 0;
        for (int i = 0; i < abilityList.size() - 1; i++) {
            for (int j = i + 1; j < abilityList.size(); j++) {
                sum += arr[abilityList.get(i)][abilityList.get(j)];
                sum += arr[abilityList.get(j)][abilityList.get(i)];
            }
        }

        return sum;
    }
}
