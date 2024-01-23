import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m, p, c;
        boolean flag = false;
        int[][] rel;
        int[] visit;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        // 사람 수
        n = Integer.parseInt(br.readLine());
        visit = new int[n + 1];

        input = br.readLine();
        st = new StringTokenizer(input);
        p = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (p < c) {
            int temp = p;
            p = c;
            c = temp;
        }

        // 관계 갯수
        m = Integer.parseInt(br.readLine());

        rel = new int[n + 1][n + 1];

        int x, y;
        for (int i = 0; i < m; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            rel[x][y] = 1;
            rel[y][x] = 1;
        }
        queue.offer(c);

        int people;
        while (!queue.isEmpty()) {
            people = queue.remove();
            if (people == p) {
                flag = true;
                break;
            }

            for (int i = 1; i <= n; i++) {
                if ((rel[people][i] == 1) && visit[i] == 0) {
                    visit[i] = visit[people] + 1;
                    queue.offer(i);
                }
            }
        }

        if (flag == true)
            System.out.println(visit[p]);
        else
            System.out.println(-1);

    }
}