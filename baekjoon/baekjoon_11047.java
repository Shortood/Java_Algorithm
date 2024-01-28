import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, K, result = 0;
        String input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        //동전 확인
        for (int i = N - 1; i >= 0; i--) {
            if (a[i] <= K) {
                result += K / a[i]; //갯수 추가
                K = K % a[i]; //남은 가치
            }
        }

        System.out.println(result);

    }
}