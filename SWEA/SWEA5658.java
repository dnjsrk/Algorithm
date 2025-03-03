import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA5658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n / 4; i++) {
                int start = 0;
                int end = n / 4;

                for (int j = 0; j < 4; j++) {
                    String hex = str.substring(start, end);
                    int num = Integer.parseInt(hex, 16);

                    if(!list.contains(num)) {
                        list.add(num);
                    }

                    start = end;
                    end += n / 4;
                }

                char c = str.charAt(n - 1);
                str = c + str.substring(0, n - 1);
            }
            Collections.sort(list);
            System.out.println("#" + tc + " " + list.get(list.size() - k));
        }
    }
}
