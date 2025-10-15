import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        int num = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();

            switch (s) {
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;

                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num))
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num))
                        set.remove(num);
                    else
                        set.add(num);
                    break;
                case "all" :
                    for (int k = 0; k < 20; k++) {
                        set.add(k + 1);
                    }
                    break;
                case "empty" :
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}
