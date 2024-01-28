import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1697 {
    public static void main(String[] args) throws IOException {
        int N, K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue.offer(N);
        int[] map = new int[100001];
        map[N] = 1;
        int now;

        while (!queue.isEmpty()) {
            now = queue.remove();
            if (now == K)
                break;

            if (now * 2 <= 100001 && map[now * 2] == 0) {
                map[now * 2] = map[now] + 1;
                queue.offer(now * 2);
            }
            if (now + 1 <= K && map[now + 1] == 0) {
                map[now + 1] = map[now] + 1;
                queue.offer(now + 1);
            }
            if (now - 1 >= 0 && map[now - 1] == 0) {
                map[now - 1] = map[now] + 1;
                queue.offer(now - 1);
            }
        }
        System.out.println(map[K] - 1);

    }
}