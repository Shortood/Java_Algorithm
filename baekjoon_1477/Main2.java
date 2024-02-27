import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, L;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] building = new int[N + 1];
        int[] distance = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        // 첫번쨰 휴게소는 0
        for (int i = 1; i <= N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(building);

        // 거리 구하기
        for (int i = 1; i <= N; i++) {
            distance[i - 1] = building[i] - building[i - 1];
        }

        // 마지막 휴게소에서 L까지 거리
        distance[N] = L - building[N];

        int start = 1;
        int end = L - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            // 겹치면 안됨
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