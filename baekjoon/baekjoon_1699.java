import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;

        N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= (int) Math.sqrt(N); j++) {
                int dj = j * j;
                if (i + dj > N)
                    break;
                dp[i + dj] = Math.min(dp[i + dj], dp[i] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}