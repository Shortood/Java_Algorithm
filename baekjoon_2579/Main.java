import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] stair = new int[N + 2];
        int[] dp = new int[N + 2];

        for (int i = 2; i <= N + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        dp[2] = stair[2];

        for (int i = 3; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i - 2], stair[i - 1] + dp[i - 3]);
            dp[i] += stair[i];
        }
        System.out.println(dp[N + 1]);
    }
}