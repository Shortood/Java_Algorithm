import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 배치, 가로, 세로
        int[][] dp = new int[N + 1][3];
        dp[1][0] = 1; // 둘다 X
        dp[1][1] = 1; // 왼
        dp[1][2] = 1; // 오

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][0]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }
}