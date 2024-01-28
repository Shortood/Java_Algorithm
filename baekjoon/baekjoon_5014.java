import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int F, S, G, U, D;
        int[] height;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        height = new int[F + 1];

        queue.offer(S);
        height[S] = 1;

        int stair, ns;

        while (!queue.isEmpty()) {
            stair = queue.remove();
            if (stair == G)
                break;

            ns = stair + U;
            if (ns >= 1 && ns <= F && height[ns] == 0) {
                height[ns] = height[stair] + 1;
                queue.offer(ns);
            }

            ns = stair - D;
            if (ns >= 1 && ns <= F && height[ns] == 0) {
                height[ns] = height[stair] + 1;
                queue.offer(ns);
            }
        }

        if (height[G] > 0)
            System.out.println(height[G] - 1);
        else
            System.out.println("use the stairs");

    }
}