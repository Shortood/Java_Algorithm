import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] paper = new int[6];
    static List<Pair> list = new ArrayList<>();
    static int min = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    list.add(new Pair(i, j));
            }
        }
        dfs(0);

        if (min == 26)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void dfs(int cnt) {
        if (cnt >= list.size()) {
            int result = paper[1] + paper[2] + paper[3] + paper[4] + paper[5];
            if (min > result)
                min = result;
            return;
        }

        Pair temp = list.get(cnt);
        if (map[temp.x][temp.y] == 1) {
            int range = checkRange(temp.x, temp.y); // 가능 범위
            for (int j = range; j > 0; j--) {
                if (paper[j] < 5) {
                    paper[j]++;
                    fillMap(temp.x, temp.y, j - 1, 0);
                    dfs(cnt + 1);
                    fillMap(temp.x, temp.y, j - 1, 1);
                    paper[j]--;
                }
            }
        } else
            dfs(cnt + 1);

    }

    static int checkRange(int x, int y) {
        int i;
        for (i = 2; i <= 5; i++) {
            for (int j = x; j < x + i; j++) {
                for (int k = y; k < y + i; k++) {
                    if (j >= 10 || k >= 10 || map[j][k] == 0)
                        return i - 1;
                }
            }
        }
        return i - 1;
    }

    static void fillMap(int x, int y, int r, int num) {
        for (int i = x; i <= x + r; i++) {
            for (int j = y; j <= y + r; j++) {
                map[i][j] = num;
            }
        }
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}