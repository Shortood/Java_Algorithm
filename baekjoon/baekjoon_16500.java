import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String S, tempString;
        String[] A;
        boolean[] dp;
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        N = Integer.parseInt(br.readLine());
        A = new String[N];
        dp = new boolean[S.length() + 1];
        dp[0] = true;

        for (int i = 0; i < N; i++)
            A[i] = br.readLine();

        for (int i = 0; i < S.length(); i++) { // S 시작 인덱스
            if (dp[i] == true) {
                for (int j = 0; j < N; j++) { // A 배열 인덱스
                    int stringLength = A[j].length() + i;
                    if ((stringLength) <= S.length()) {
                        // 비교할 문자열
                        tempString = S.substring(i, stringLength);
                        // 같으면
                        if (tempString.equals(A[j]))
                            dp[stringLength] = true;
                    }
                }
            }
        }

        if (dp[S.length()] == true)
            System.out.println(1);
        else
            System.out.println(0);
    }
}