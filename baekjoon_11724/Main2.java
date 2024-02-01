import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N, M;
    static int[] union;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = N;

        union = new int[N + 1];

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if (union(u, v)) {
                result--;
            }
        }

        System.out.println(result);
    }

    static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return false;

        //간곳은 다시 가지 않도록 합쳐주기
        if (union[u] < union[v]) {
            union[v] = u;
        } else {
            union[u] = v;
        }

        return true;

    }

    static int find(int u) {
        if (union[u] == 0)
            return u;
        else {
            union[u] = find(union[u]);
            return union[u];
        }
    }

}