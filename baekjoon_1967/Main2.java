import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static List<Node>[] list;
    static int n, result = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        // leaf 노드만 dfs
        boolean[] isLeaf = new boolean[n + 1];
        Arrays.fill(isLeaf, true);

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
            isLeaf[a] = false;
        }

        for (int i = 1; i <= n; i++) {
            if (isLeaf[i]) {
                visit = new boolean[n + 1];
                visit[i] = true;
                dfs(i, 0);
            }
        }

        System.out.println(result);
    }

    static void dfs(int index, int leng) {
        if (leng > result)
            result = leng;
        for (int i = 0; i < list[index].size(); i++) {
            Node next = list[index].get(i);
            if (!visit[next.end]) {
                visit[next.end] = true;
                dfs(next.end, leng + next.weight);
            }
        }
    }

    static class Node {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
