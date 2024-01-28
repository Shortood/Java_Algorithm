import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2193 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // long[][] dp;
        long[] fibo;
        N = Integer.parseInt(br.readLine());

        // dp = new long[2][N + 1];
        fibo = new long[90];
        // dp[1][1] = 1;
        fibo[0] = 1;
        fibo[1] = 1;

        // for (int i = 2; i <= N; i++) {
        // dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
        // dp[1][i] = dp[0][i - 1];
        // }
        for (int i = 2; i < N; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[N - 1]);
        // System.out.println((dp[0][N] + dp[1][N]));
    }

}