
import java.util.*;

public class Main {
    static int c, n, m;
    static int[] dp = new int[201];
    static int result = 0;
    public static int[] price = new int[20];
    public static int[] prefer = new int[20];

    public static int DP() {
        dp[0] = 0;
        for (int i = 1; i <= m; i++) { //가격
            int sel = 0;
            for (int j = 0; j < n; j++) {
                if (i >= price[j])
                    sel = Math.max(dp[(i - price[j]) % 201] + prefer[j], sel);
            }
            dp[i % 201] = sel;
            result = Math.max(result, sel);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); //테스트 케이스 수
        for (int p = 0; p < c; p++) {
            result = 0;
            n = sc.nextInt(); //초밥 종류
            m = sc.nextInt() / 100; //예산
            for (int i = 0; i < n; i++) {
                price[i] = sc.nextInt() / 100;
                prefer[i] = sc.nextInt();
            }
            System.out.println(DP());
        }
    }
}
