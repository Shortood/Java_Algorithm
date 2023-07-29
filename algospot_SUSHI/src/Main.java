
import java.util.*;

public class Main {
    static int c, n, m;
    static int[] dp = new int[201];
    static int result = 0;

    static Vector<Pair> sushi = new Vector<Pair>();

    static class Pair {
        int price, prefer;

        public Pair(int price, int prefer) {
            this.price = price;
            this.prefer = prefer;
        }

    }

    public static int DP() {
        for (int i = 1; i <= m; i++) { //가격
            int sel = 0;
            for (int j = 0; j < n; j++) {
                if (i >= sushi.get(j).price)
                    sel = Math.max(dp[(i - sushi.get(j).price) % 201] + sushi.get(j).price, sel);
            }
            dp[i % 201] = sel;
        }
        return dp[m % 201];
    }


    public static void main(String[] args) {
        int c1, c2;
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); //테스트 케이스 수
        for (int p = 0; p < c; p++) {
            n = sc.nextInt(); //초밥 종류
            m = sc.nextInt() / 100; //예산
            for (int i = 0; i < n; i++) {
                c1 = sc.nextInt() / 100;
                c2 = sc.nextInt();
                sushi.add(new Pair(c1, c2));
            }
            System.out.println(DP());
            sushi.clear();
        }
    }
}
