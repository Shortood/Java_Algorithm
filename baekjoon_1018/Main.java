import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min, result = Integer.MAX_VALUE;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(black(i, j), white(i, j));
                if (result > min)
                    result = min;
            }
        }
        System.out.println(result);
    }

    public static int black(int a, int b) {
        int cnt = 0;
        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {
                if (i % 2 == 0) { // 홀수 줄
                    if (j % 2 == 0) {
                        if (map[i][j] != 'B')
                            cnt++;
                    } else {
                        if (map[i][j] != 'W')
                            cnt++;
                    }
                } else { // 짝수 줄
                    if (j % 2 == 0) {
                        if (map[i][j] != 'W')
                            cnt++;
                    } else {
                        if (map[i][j] != 'B')
                            cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static int white(int a, int b) {
        int cnt = 0;
        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {
                if (i % 2 == 0) { // 홀수 줄
                    if (j % 2 == 0) {
                        if (map[i][j] != 'W')
                            cnt++;
                    } else {
                        if (map[i][j] != 'B')
                            cnt++;
                    }
                } else { // 짝수 줄
                    if (j % 2 == 0) {
                        if (map[i][j] != 'B')
                            cnt++;
                    } else {
                        if (map[i][j] != 'W')
                            cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}