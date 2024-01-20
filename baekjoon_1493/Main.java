import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int length, width, height, N, d, result = 0;
    static int[][] cube;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;

        input = br.readLine();
        st = new StringTokenizer(input);

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        cube = new int[N][2];
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            cube[i][0] = Integer.parseInt(st.nextToken());
            cube[i][1] = Integer.parseInt(st.nextToken());
        }

        sol(length, width, height);
        if (flag == false)
            System.out.println(-1);
        else
            System.out.println(result);

    }

    public static void sol(int l, int w, int h) {
        if (l == 0 || w == 0 || h == 0)
            return;
        int powd;

        if (flag == false)
            return;

        int min;
        min = Math.min(l, w);
        min = Math.min(min, h);

        // 넣을 수 있는 가장 큰 큐브 길이
        d = checkMin(logB(min, 2));

        // 못 넣는다면
        if (d == -1) {
            flag = false;
            return;
        }

        result++;
        powd = (int) Math.pow(2, d);

        sol(l, w, h - powd);
        sol(l, w - powd, powd);
        sol(l - powd, powd, powd);
    }

    public static int logB(int x, int y) {
        return (int) (Math.log10(x) / Math.log10(y));
    }

    public static int checkMin(int d) {
        for (int i = N - 1; i >= 0; i--) {
            if (cube[i][0] <= d && cube[i][1] > 0) {
                cube[i][1]--;
                return cube[i][0];
            }
        }
        return -1;
    }
}