import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int result = 0;
        int N, K, W, V;
        int[] dp;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();
        st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            W = Integer.parseInt(st.nextToken()); // 무게
            V = Integer.parseInt(st.nextToken()); // 가치

            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
                result = Math.max(result, dp[j]);
            }
        }
        System.out.println(result);
    }
}