import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M, start, end;
        int[] result;
        boolean[] visit;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        result = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        List<Node>[] list = new List[N + 1];
        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        result[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.remove(); // 현재 노드
            int to = now.end;

            if (visit[to])
                continue;
            // 방문 처리 들어와서 해야함
            visit[to] = true;

            for (int i = 0; i < list[to].size(); i++) {
                Node next = list[to].get(i); // 다음 노드
                if (result[next.end] > result[to] + next.weight) {
                    result[next.end] = result[to] + next.weight;
                    pq.offer(new Node(next.end, result[next.end]));
                }
            }
        }

        System.out.println(result[end]);
    }
}

class Node {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}