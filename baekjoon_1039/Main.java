import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, K, result = -1;
        boolean visit[][];
        Queue<Pair> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[1000001][K + 1];
        queue.offer(new Pair(N, 0));

        Pair pair;
        while (!queue.isEmpty()) {
            pair = queue.remove();
            if (pair.cnt == K) {
                if (result < pair.num)
                    result = pair.num;
            } else {
                int length = (int) (Math.log10(pair.num) + 1);
                for (int i = 1; i <= length; i++) {
                    for (int j = i + 1; j <= length; j++) {
                        int nNumber = getNextNumber(pair.num, i, j);
                        if (nNumber != -1 && visit[nNumber][pair.cnt + 1] == false) {
                            queue.offer(new Pair(nNumber, pair.cnt + 1));
                            visit[nNumber][pair.cnt + 1] = true;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    static int getNextNumber(int num, int i, int j) {
        int pow1 = (int) Math.pow(10, i - 1);
        int pow2 = (int) Math.pow(10, j - 1);
        int num1 = (num / pow1) % 10;
        int num2 = (num / pow2) % 10;
        if (j == (int) (Math.log10(num) + 1) && num1 == 0)
            return -1;
        else
            return num - num1 * pow1 - num2 * pow2 + num1 * pow2 + num2 * pow1;
    }
}

class Pair {
    int num, cnt;

    Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}