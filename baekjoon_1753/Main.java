import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        result = new int[V + 1];

        PriorityQueue<Node> pQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        List<Node>[] list = new List[V + 1];

        int start = Integer.parseInt(br.readLine());

        for (int i = 1; i <= V; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        // 최대값
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        pQueue.offer(new Node(start, 0));

        Node now;
        while (!pQueue.isEmpty()) {
            now = pQueue.remove(); // 현재
            for (int i = 0; i < list[now.end].size(); i++) {
                Node next = list[now.end].get(i); // 다음 노드
                if (result[next.end] > next.weight + result[now.end]) {
                    result[next.end] = next.weight + result[now.end];
                    pQueue.offer(new Node(next.end, result[next.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(result[i]);
        }

    }
}

class Node {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}