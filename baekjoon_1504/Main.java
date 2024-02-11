import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, E;
    static boolean[] visit;
    static int[] result;
    static List<Node>[] list;
    static int MAX_VALUE = 200000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new List[N + 1];

        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int v1, v2;
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        if (result1 >= MAX_VALUE && result2 >= MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(Math.min(result1, result2));
    }

    static int dijkstra(int s, int e) {
        visit = new boolean[N + 1];
        result = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        Arrays.fill(result, MAX_VALUE);
        result[s] = 0;
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