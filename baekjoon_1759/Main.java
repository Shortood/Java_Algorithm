import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] al;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        al = new char[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++)
            al[i] = st.nextToken().charAt(0);

        Arrays.sort(al);

        dfs(0, 0, "", 0);

    }

    static void dfs(int n1, int n2, String str, int index) {
        if (n1 + n2 == L) {
            if (n1 >= 1 && n2 >= 2)
                System.out.println(str);
            return;
        }
        if (index >= C)
            return;

        if (al[index] == 'a' || al[index] == 'e' || al[index] == 'i' || al[index] == 'o' || al[index] == 'u')
            dfs(n1 + 1, n2, str + al[index], index + 1);
        else
            dfs(n1, n2 + 1, str + al[index], index + 1);
        dfs(n1, n2, str, index + 1);
    }
}