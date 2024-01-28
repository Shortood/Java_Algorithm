import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_16397 {
    public static void main(String[] args) throws IOException {
        int N, T, G;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        int[] led = new int[100000];
        queue.offer(N);
        led[N] = 1;

        int now, tempnum;
        while (!queue.isEmpty()) {
            now = queue.remove();
            if (now == G)
                break;

            if (led[now] > T)
                continue;

            if (now + 1 < 100000 && led[now + 1] == 0) {
                led[now + 1] = led[now] + 1;
                queue.offer(now + 1);
            }
            if (now * 2 < 100000 & now != 0) {
                tempnum = getNumber(now);
                if (led[tempnum] == 0) {
                    led[tempnum] = led[now] + 1;
                    queue.offer(tempnum);
                }
            }
        }

        if (led[G] == 0)
            System.out.println("ANG");
        else
            System.out.println(led[G] - 1);
    }

    static int getNumber(int n) {
        int num = n * 2;
        int pow = (int) (Math.log10(num) + 1);
        num = num - (int) (Math.pow(10, pow - 1));
        return num;
    }
}
