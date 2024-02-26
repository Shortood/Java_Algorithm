import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] list;
    static int n, result = 0, findNode = 1;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        // 루트 node에서 가중치 가장 큰 node 찾음
        visit = new boolean[n + 1];
        dfs(1, 0);

        result = 0;
        Arrays.fill(visit, false);
        dfs(findNode, 0);

        System.out.println(result);
    }

    static void dfs(int index, int leng) {
        visit[index] = true;
        if (leng > result) {
            result = leng;
            findNode = index;
        }
        for (int i = 0; i < list[index].size(); i++) {
            Node next = list[index].get(i);
            if (!visit[next.end]) {
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
