import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, result = 0;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);
        a = new int[N];

        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        System.out.println(result);

    }

    static public void dfs(int sum, int index) {
        if (index >= N)
            return;
        if (sum + a[index] == S) // 합이 같은 경우
            result++;

        // 더하는 경우
        dfs(sum + a[index], index + 1);

        // 안 더하는 경우
        dfs(sum, index + 1);
    }
}