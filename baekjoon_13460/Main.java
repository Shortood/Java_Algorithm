//dfs에 구슬들 x,y, 이동횟수, 이전 방향 저장
//이전 방향 제외하고 다시 dfs
//파란 구슬 먼저 이동
//이동하다 구멍 -> 빨간 구슬 지나갔으면 성공 아니면 실패
//빨간 구슬 이동
//이동하가 구멍 -> 성공

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 11, N, M;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int bx = 0, by = 0, rx = 0, ry = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
            }
        }
        dfs(bx, by, rx, ry, 1, 5);
        if (result == 11)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    static void dfs(int bx, int by, int rx, int ry, int cnt, int dir) {
        // System.out.println(bx + " " + by + " " + rx + " " + ry + " " + cnt + " " +
        // dir);
        if (cnt > 10)
            return; // 북 남 동 서
        for (int i = 0; i < 4; i++) {
            if (i == 0 && dir == 1 || i == 1 && dir == 0 || i == 2 && dir == 3 || i == 3 && dir == 2) { // 이전 방향 제외
                continue;
            }
            int nx = bx, ny = by;// 파란 구슬 이동
            int nbx = nx, nby = by;
            boolean isRed = false, blueEscape = false;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (nx == rx && ny == ry) // 빨간 구슬 지나감
                        isRed = true;
                    if (map[nx][ny] == '#') {
                        break;
                    } else if (map[nx][ny] == 'O') {
                        blueEscape = true;
                        break;
                    }
                    nbx = nx;
                    nby = ny;
                }
            }
            if (blueEscape)
                continue;
            // 파란 구슬 다음 좌표
            boolean isBlue = false;
            // 빨간 구슬 이동
            nx = rx;
            ny = ry;
            // 빨간 구슬 다음 좌표
            int nrx = nx, nry = ny;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (nx == bx && ny == by) // 파란 구슬 지나감
                        isBlue = true;
                    if (map[nx][ny] == '#') {
                        break;
                    } else if (map[nx][ny] == 'O') {
                        result = Math.min(result, cnt);
                        return;
                    }
                    nrx = nx;
                    nry = ny;
                }
            }

            if (nrx == nbx && nry == nby) {
                if (isBlue) {
                    nrx -= dx[i];
                    nry -= dy[i];
                } else {
                    nbx -= dx[i];
                    nby -= dy[i];
                }
            }
            if (!(nbx == bx && nrx == rx && nby == by && nry == ry))
                dfs(nbx, nby, nrx, nry, cnt + 1, i);
        }
    }
}