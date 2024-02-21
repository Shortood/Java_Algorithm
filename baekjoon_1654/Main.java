import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()),
                N = Integer.parseInt(st.nextToken());

        int[] line = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if (line[i] > max)
                max = line[i];
        }
        long min = 1;

        while (min <= max) {
            long mid = (max + min) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += (line[i] / mid);
            }

            if (cnt < N)
                max = mid - 1;
            else
                min = mid + 1;

        }
        System.out.println(min - 1);
    }
}