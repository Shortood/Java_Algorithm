import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());

        int[] score = new int[N];
        st = new StringTokenizer(br.readLine());
        int end = 0;
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            end += score[i];
        }
        int start = 0;

        while (start <= end) {
            // 기준 점수
            int cnt = 0;
            int sum = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                sum += score[i];
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }

            if (cnt >= K)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(end);
    }
}