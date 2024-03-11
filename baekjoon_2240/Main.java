import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()),
                W = Integer.parseInt(st.nextToken()),
                result = 0;
        int tree;
        int[][] dp = new int[W + 1][T + 1]; // 움직인 횟수/자두 인덱스

        for (int i = 1; i <= T; i++) {
            tree = Integer.parseInt(br.readLine());
            for (int j = 0; j <= W; j++) { // 움직인 횟수
                if (j == 0) { // 안 움직인 경우
                    if (tree == 1)
                        dp[j][i] = dp[j][i - 1] + 1;
                    else
                        dp[j][i] = dp[j][i - 1];
                } else { // 한 번 이상 움직인 경우
                    if (j % 2 == 0) { // 짝수는 1
                        if (tree == 1) // 같은 위치
                            dp[j][i] = Math.max(dp[j - 1][i - 1], dp[j][i - 1] + 1);
                        else // 다른 위치
                            dp[j][i] = Math.max(dp[j - 1][i - 1] + 1, dp[j][i - 1]);
                    } else { // 홀수는 2
                        if (tree == 2) // 같은 위치
                            dp[j][i] = Math.max(dp[j - 1][i - 1], dp[j][i - 1] + 1);
                        else // 다른 위치
                            dp[j][i] = Math.max(dp[j - 1][i - 1] + 1, dp[j][i - 1]);
                    }
                }

            }
        }

        for (int i = 1; i <= W; i++) {
            if (result < dp[i][T])
                result = dp[i][T];
        }
        System.out.println(result);
    }
}