import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int H, W;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = map[i], right = map[i];
            for (int j = 0; j < i; j++) {
                if (left < map[j])
                    left = map[j];
            }

            for (int j = i + 1; j < W; j++) {
                if (right < map[j])
                    right = map[j];
            }
            int height = Math.min(left, right);
            result += height - map[i];
        }

        System.out.println(result);
    }
}