// 카메라 list로 저장
// dfs dep의 카메라 확인
//case 나눠서 반복

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map;
    static List<Pair> list = new ArrayList<>();
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = N * M;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5)
                    list.add(new Pair(i, j));
            }
        }
        dfs(0, map);
        System.out.println(result);
    }

    static void dfs(int depth, int[][] newMap) {
        int x, y;
        if (depth == list.size()) {
            result = Math.min(result, cal(newMap));
            return;
        }
        Pair camera = list.get(depth);
        int[][] copyMap = new int[N][M];
        switch (map[camera.x][camera.y]) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < N; j++)
                        copyMap[j] = newMap[j].clone();
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[i];
                        y = y + dy[i];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    dfs(depth + 1, copyMap);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < N; j++)
                        copyMap[j] = newMap[j].clone();
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[i];
                        y = y + dy[i];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[i + 2];
                        y = y + dy[i + 2];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    dfs(depth + 1, copyMap);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < N; j++)
                        copyMap[j] = newMap[j].clone();
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[i];
                        y = y + dy[i];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[(i + 1) % 4];
                        y = y + dy[(i + 1) % 4];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    dfs(depth + 1, copyMap);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < N; j++)
                        copyMap[j] = newMap[j].clone();
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[i];
                        y = y + dy[i];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[(i + 1) % 4];
                        y = y + dy[(i + 1) % 4];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[(i + 2) % 4];
                        y = y + dy[(i + 2) % 4];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                    dfs(depth + 1, copyMap);
                }
                break;
            case 5:
                for (int j = 0; j < N; j++)
                    copyMap[j] = newMap[j].clone();
                for (int i = 0; i < 4; i++) {
                    x = camera.x;
                    y = camera.y;
                    while (true) {
                        x = x + dx[i];
                        y = y + dy[i];
                        if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
                            if (map[x][y] == 0)
                                copyMap[x][y] = 7;
                        } else
                            break;
                    }
                }
                dfs(depth + 1, copyMap);
                break;
        }
    }

    static int cal(int[][] calMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (calMap[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}