import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());

        int[] dp = new int[100001];
        boolean[] visit = new boolean[100001];

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        queue.offer(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node now = queue.remove();
            visit[now.n] = true;

            if (now.n == K) {
                System.out.println(now.cnt);
                return;
            }

            if (now.n * 2 <= 100000 && !visit[now.n * 2])
                queue.offer(new Node(now.n * 2, now.cnt));
            if (now.n - 1 >= 0 && !visit[now.n - 1])
                queue.offer(new Node(now.n - 1, now.cnt + 1));
            if (now.n + 1 <= 100000 && !visit[now.n + 1])
                queue.offer(new Node(now.n + 1, now.cnt + 1));

        }

    }

    static class Node {
        int n;
        int cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}