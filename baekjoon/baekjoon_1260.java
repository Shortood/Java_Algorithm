import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static int[][] map;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        int x, y;
        Queue<Integer> queue = new LinkedList<>();

        input = br.readLine();
        st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }
        // dfs
        dfs(V);

        // bfs
        // 방문 초기화
        Arrays.fill(check, false);
        queue.add(V);
        check[V] = true;
        System.out.println();
        while (!queue.isEmpty()) {
            V = queue.remove();
            System.out.print(V + " ");
            for (int i = 1; i <= N; i++) {
                if (map[V][i] > 0 && check[i] == false) {
                    check[i] = true;
                    queue.add(i);
                }
            }
        }

    }

    public static void dfs(int v) {
        if (check[v] == true)
            return;
        System.out.print(v + " ");
        check[v] = true;
        for (int i = 1; i <= N; i++) { //연결된 부분 dfs
            if (map[v][i] > 0)
                dfs(i);
        }
    }
}