import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int[] card, dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        card = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++)
            card[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) { // 갯수
            for (int j = 1; j <= i; j++) { // j개 짜리 카드팩 더함
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
            }
        }

        System.out.println(dp[N]);
    }
}