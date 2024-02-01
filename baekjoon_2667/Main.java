import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, -1, 1 };
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        int tempResult;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrayList = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && visit[i][j] == false) {
                    visit[i][j] = true;
                    tempResult = dfs(i, j);
                    arrayList.add(tempResult);
                }
            }
        }
        System.out.println(arrayList.size());
        arrayList.sort(Comparator.naturalOrder());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    static int dfs(int x, int y) {
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == '1' && visit[nx][ny] == false) {
                visit[nx][ny] = true;
                cnt += dfs(nx, ny);
            }

        }
        return cnt;
    }
}