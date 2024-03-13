// dfs visit이용
// 각 나라 보면서 dfs, 나라 갯수, 인구 합 구함
// 나라 갯수 2개 이상이면 다시 dfs 돌면서 값 넣기
// or
// ArrayList에 x,y 값 넣고 size

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static boolean[][] visit;
    static int[][] map;
    static int N, L, R, sum;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            boolean isMove = false;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        sum = 0; // 인구 합
                        dfs(i, j);
                        if (list.size() > 1) { // 인구 이동 해야함
                            isMove = true;
                            int newNum = sum / list.size();
                            for (int k = 0; k < list.size(); k++) {
                                map[list.get(k).x][list.get(k).y] = newNum;
                            }
                        }
                        list.clear();
                    }
                }
            }
            if (!isMove)
                break;
            result++;
        }
        System.out.println(result);
    }

    static void dfs(int x, int y) {
        sum += map[x][y];
        visit[x][y] = true;
        list.add(new Pair(x, y));
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]
                    && Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                dfs(nx, ny);
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}