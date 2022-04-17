
//배열을 사용하지 않고 나선형 출력
import java.util.*;

public class spiral_print {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int s, a = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s = Math.min(Math.min(i, j), Math.min(n - i - 1, n - j - 1));
                if (i <= j)
                    a = i + j - 2 * s;
                else
                    a = (n - 1 - 2 * s) * 4 - (i + j - 2 * s);
                a += 4 * (s * n - Math.pow(s, 2));
                System.out.printf("%2d ", a);
            }
            System.out.println();
        }
        input.close();
    }
}
