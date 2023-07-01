import java.util.Scanner;

public class Main {
    static int[][] map;
    static int result, x, y;
    static int N, mid;

    static void to(int dir, int cnt) { //방향, 이동 횟수
        int[][] dx = {{-1, -1, -2, -1, 0, 1, 1, 2, 1, 0}
                , {0, 1, 1, 2, 3, 2, 1, 1, 0, 1}
                , {1, 1, 2, 1, 0, -1, -1, -2, -1, 0}
                , {0, -1, -1, -2, -3, -2, -1, -1, 0, -1}};
        int[][] dy = {{0, -1, -1, -2, -3, -2, -1, -1, 0, -1}
                , {-1, -1, -2, -1, 0, 1, 1, 2, 1, 0}
                , {0, 1, 1, 2, 3, 2, 1, 1, 0, 1}
                , {1, 1, 2, 1, 0, -1, -1, -2, -1, 0}};
        int[] dz = {1, 7, 2, 10, 5, 10, 7, 2, 1};
        int temp; //날아간 양
        int xx, yy; //날아갈 위치
        for (int q = 0; q < cnt; q++) { //cnt 만큼 반복
            temp = 0;
            if (x == 0 && y == 0)
                return;

            for (int i = 0; i < 9; i++) {
                xx = x + dx[dir][i];
                yy = y + dy[dir][i];
                int send = map[x + dx[dir][9]][y + dy[dir][9]] * dz[i] / 100;
                if (xx >= 0 && xx < N && yy >= 0 && yy < N) {
                    map[xx][yy] += send;
                    temp += send;
                } else {
                    temp += send;
                }
            }

            switch (dir) {
                case 0: //왼
                    if (x >= 0 && x < N && y - 2 >= 0 && y - 2 < N)
                        map[x][y - 2] += (map[x][y - 1] - temp); //a로 날아감
                    map[x][y - 1] = 0;
                    y--;
                    break;
                case 1: //아래
                    if (x + 2 >= 0 && x + 2 < N && y >= 0 && y < N)
                        map[x + 2][y] += (map[x + 1][y] - temp); //a로 날아감
                    map[x + 1][y] = 0;
                    x++;
                    break;
                case 2: //오
                    if (x >= 0 && x < N && y + 2 >= 0 && y + 2 < N)
                        map[x][y + 2] += (map[x][y + 1] - temp); //a로 날아감
                    map[x][y + 1] = 0;
                    y++;
                    break;
                case 3: //위
                    if (x - 2 >= 0 && x - 2 < N && y >= 0 && y < N)
                        map[x - 2][y] += (map[x - 1][y] - temp); //a로 날아감
                    map[x - 1][y] = 0;
                    x--;
                    break;
            }
        }

        switch (dir) {
            case 0: //왼
                to(1, cnt);
                break;
            case 1: //아래
                to(2, cnt + 1);
                break;
            case 2: //오
                to(3, cnt);
                break;
            case 3: //위
                to(0, cnt + 1);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        mid = N / 2 + 1;
        x = mid - 1;
        y = x;
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[N];
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                result += map[i][j];
            }
        }

        to(0, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result -= map[i][j];
            }
        }
        System.out.println(result);
    }
}