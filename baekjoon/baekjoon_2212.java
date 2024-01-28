import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    static int N, K;
    static int[] a;
    static Integer[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        a = new int[N];
        b = new Integer[N - 1];

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬
        Arrays.sort(a);

        //사이 거리 구하기
        for (int i = 0; i < N - 1; i++) {
            b[i] = a[i + 1] - a[i];
        }

        //거리 오름차순 정렬
        Arrays.sort(b);

        int result = 0;

        //가장 큰 K개 사이 거리 빼고 합 구하기
        for (int i = 0; i < N - K; i++)
            result += b[i];

        System.out.println(result);

    }
}