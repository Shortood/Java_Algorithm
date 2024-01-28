import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class baekjoon_1449 {
    static int N, L;
    static int[] a;

    public static void main(String[] args) throws IOException {
        int result = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        a = new int[N];
        input = br.readLine();
        st = new StringTokenizer(input);

        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int possible = a[0] + L - 1; //테이프 붙임
        for (int i = 1; i < N; i++) {
            if (a[i] > possible) { //테이프를 붙여야 한다면
                result++;
                possible = a[i] + L - 1; //안 붙여도 되는 위치 설정
            }
        }

        System.out.println(result);

    }
}