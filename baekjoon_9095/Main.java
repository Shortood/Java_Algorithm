import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, result, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            result = 0;
            n = Integer.parseInt(br.readLine());
            dfs(0);
            System.out.println(result);
        }
    }

    static void dfs(int num) {
        if (num == n) {
            result++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (num + i <= n)
                dfs(num + i);
        }
    }
}