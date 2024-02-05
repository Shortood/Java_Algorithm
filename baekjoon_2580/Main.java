import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static List<Pair> list = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    list.add(new Pair(i, j));
            }
        }
        sol(0);
    }

    static void sol(int cnt) {
        if (flag == true)
            return;
        if (cnt >= list.size()) {
            printMap();
            flag = true;
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (check(i, list.get(cnt).x, list.get(cnt).y)) { // 숫자 넣을 수 있음
                map[list.get(cnt).x][list.get(cnt).y] = i;
                sol(cnt + 1);
                map[list.get(cnt).x][list.get(cnt).y] = 0;
            }
        }
    }

    static boolean check(int num, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num || map[i][y] == num)
                return false;
        }

        int sx = (x / 3) * 3, sy = (y / 3) * 3;
        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (map[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    static void printMap() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
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