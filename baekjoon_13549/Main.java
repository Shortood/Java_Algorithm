import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken()),
                result = 1000000;

        int[] dp = new int[100001];
        boolean[] visit = new boolean[100001];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node now = queue.remove();
            visit[now.n] = true;
            
            if (now.n == K)
                result = Math.min(result, now.cnt);

            if (now.n * 2 <= 100000 && !visit[now.n * 2])
                queue.offer(new Node(now.n * 2, now.cnt));
            if (now.n - 1 >= 0 && !visit[now.n - 1])
                queue.offer(new Node(now.n - 1, now.cnt + 1));
            if (now.n + 1 <= 100000 && !visit[now.n + 1])
                queue.offer(new Node(now.n + 1, now.cnt + 1));

        }

        System.out.println(result);
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