import java.util.Scanner;

public class BOJ2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String[] letter = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < letter.length; i++) {
            if (str.contains(letter[i])) {
                str = str.replace(letter[i], ".");
            }
        }

        System.out.println(str.length());
    }
}
