import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class temp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, L, end = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] building = new int[N + 1];
        int[] distance = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(building);
        for (int i = 1; i <= N; i++) {
            distance[i - 1] = building[i] - building[i - 1];
            if (distance[i - 1] > end)
                end = distance[i - 1];
        }
        distance[N] = L - building[N];
        if (distance[N] > end)
            end = distance[N];

        int start = 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 0; i <= N; i++) {
                cnt += ((distance[i] - 1) / mid);
            }

            if (cnt > M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(start);
    }
}