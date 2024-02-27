import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int result = 0, maxNode = 1;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1)
                    break;
                int c = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, c));
            }
        }
        visit = new boolean[N + 1];
        dfs(1, 0);

        visit = new boolean[N + 1];
        result = 0;
        dfs(maxNode, 0);
        System.out.println(result);
    }

    static void dfs(int index, int dis) {
        visit[index] = true;
        if (dis > result) {
            result = dis;
            maxNode = index;
        }
        for (Node node : list[index]) {
            if (!visit[node.end])
                dfs(node.end, dis + node.distance);
        }
    }

    static class Node {
        int end, distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}
