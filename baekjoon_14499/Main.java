//주사위 움직이는 경우 케이스 나누기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
                x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());
        int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
        int[][] map = new int[N][M];
        int[][] dice = new int[4][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int input; // 명령
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            input = Integer.parseInt(st.nextToken());
            int temp;
            int nx = x + dx[input - 1], ny = y + dy[input - 1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // 이동가능
                switch (input) {
                    case 1: // 동
                        temp = dice[1][0];
                        dice[1][0] = dice[3][1];
                        dice[3][1] = dice[1][2];
                        dice[1][2] = dice[1][1];
                        dice[1][1] = temp;
                        break;
                    case 2: // 서
                        temp = dice[1][0];
                        dice[1][0] = dice[1][1];
                        dice[1][1] = dice[1][2];
                        dice[1][2] = dice[3][1];
                        dice[3][1] = temp;
                        break;
                    case 3: // 북
                        temp = dice[0][1];
                        dice[0][1] = dice[1][1];
                        dice[1][1] = dice[2][1];
                        dice[2][1] = dice[3][1];
                        dice[3][1] = temp;
                        break;
                    case 4: // 남
                        temp = dice[0][1];
                        dice[0][1] = dice[3][1];
                        dice[3][1] = dice[2][1];
                        dice[2][1] = dice[1][1];
                        dice[1][1] = temp;
                        break;
                }
                // 주사위 이동
                x = nx;
                y = ny;
                if (map[x][y] == 0) {
                    map[x][y] = dice[3][1];
                } else {
                    dice[3][1] = map[x][y];
                    map[x][y] = 0;
                }
                System.out.println(dice[1][1]);
            }
        }
    }
}