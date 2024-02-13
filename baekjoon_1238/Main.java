import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static boolean[] visit;
    static int[] result;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new List[N + 1];

        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));
        }
        System.out.println(max);
    }

    static int dijkstra(int s, int e) {
        visit = new boolean[N + 1];
        result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node now = pq.remove();
            int to = now.end;
            if (visit[to])
                continue;
            visit[to] = true;

            for (int i = 0; i < list[to].size(); i++) {
                Node next = list[to].get(i);
                if (result[next.end] > result[to] + next.weight) {
                    result[next.end] = result[to] + next.weight;
                    pq.offer(new Node(next.end, result[next.end]));
                }
            }
        }

        return result[e];
    }
}

class Node {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}