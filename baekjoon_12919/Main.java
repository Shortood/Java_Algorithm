import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        dfs(T);
        System.out.println(0);
    }

    static void dfs(String str) {
        if (str.length() == 0 || str.length() < S.length())
            return;

        if (str.equals(S)) {
            System.out.println(1);
            System.exit(0);
        }

        if (str.charAt(0) == 'B') {
            StringBuilder newSb = new StringBuilder(str.substring(1));
            dfs(newSb.reverse().toString());
        }

        if (str.charAt(str.length() - 1) == 'A')
            dfs(str.substring(0, str.length() - 1));

    }
}