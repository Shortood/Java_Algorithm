import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A, dp;
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        dp = new int[N + 1];
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = A[i];
        }

        dp[1] = A[1];
        result = A[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}