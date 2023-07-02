import java.util.Scanner;

public class Main {
    static int N, r, c;
    static int ans = 0;

    public static void zet(int x, int y, int cnt) {
        if ((r >= x) && (c >= y) && (r < x + cnt) && (c < y + cnt)) {
            zet(x, y, cnt / 2);

            zet(x, y + cnt / 2, cnt / 2);

            zet(x + cnt / 2, y, cnt / 2);

            zet(x + cnt / 2, y + cnt / 2, cnt / 2);
        } else ans += cnt * cnt;

        if (x == r && y == c) {
            System.out.println(ans);
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        int num = (int) Math.pow(2, N);
        zet(0, 0, num);
    }
}