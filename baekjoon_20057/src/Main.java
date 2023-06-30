import java.util.Scanner;

public class Main {
    static int[][] map;
    static int result = 0, x, y;
    static int N, mid;

    static void to(int dir, int cnt) { //방향, 이동 횟수
        int[][] dx = {{-1, -1, -2, -1, 0, 1, 1, 2, 1, 0}
                , {0, 1, 1, 2, 3, 2, 1, 1, 0, 1}
                , {1, 1, 2, 1, 0, -1, -1, -2, -1, 0}
                , {0, -1, -1, -2, -3, -2, -1, -1, 0, -1}};
        int[][] dy = {{0, -1, -1, -2, -3, -2, -1, -1, 0, -1}
                , {-1, -1, -2, -2, 0, 1, 1, 2, 1, 0}
                , {0, 1, 1, 2, 3, 2, 1, 1, 0, 1}
                , {1, 1, 2, 1, 0, -1, -1, -2, -1, 0}};
        int[] dz = {1, 7, 2, 10, 5, 10, 7, 2, 1};
        int temp = 0; //날아간 양
        int xx, yy; //날아갈 위치
        for (int q = 0; q < cnt; q++) {
            if (x == 0 && y == 0)
                return;
            System.out.println("x : " + x + " y : " + y + " cnt : " + cnt + " result : " + result);
            System.out.println("Map : " + map[x + dx[dir][9]][y + dy[dir][9]]);
            for (int i = 0; i < 9; i++) {
                xx = x + dx[dir][i];
                yy = y + dy[dir][i];
                System.out.println("xx : " + xx + " yy : " + yy);
                int send = map[x + dx[dir][9]][y + dy[dir][9]] / 100 * dz[i];
                if (xx >= 0 && xx < N && yy >= 0 && yy < N) {
                    map[xx][yy] += send;
                    System.out.println("안 나감 " + send + "-> " + map[xx][yy]);
                    temp += send;
                } else {
                    System.out.println("나감 " + send);
                    result += send;
                    temp += send;
                }
                System.out.println("temp : " + temp);
            }

            switch (dir) {
                case 0: //왼
                    if (x >= 0 && x < N && y - 2 >= 0 && y - 2 < N) {
                        map[x][y - 2] += (map[x][y - 1] - temp); //a로 날아감
                        System.out.println("날아감 : " + map[x][y - 2]);
                        System.out.println(x + " " + y);
                    } else result += (map[x][y - 1] - temp);
                    map[x][y - 1] = 0;
                    y--;
                    break;
                case 1: //아래
                    if (x + 2 >= 0 && x + 2 < N && y >= 0 && y < N)
                        map[x + 2][y] += (map[x + 1][y] - temp); //a로 날아감
                    else result += (map[x + 1][y] - temp);
                    map[x + 1][y] = 0;
                    x++;
                    break;
                case 2: //오
                    if (x >= 0 && x < N && y + 2 >= 0 && y + 2 < N)
                        map[x][y + 2] += (map[x][y + 1] - temp); //a로 날아감
                    else result += (map[x][y + 1] - temp);
                    map[x][y + 1] = 0;
                    y++;
                    break;
                case 3: //위
                    if (x - 2 >= 0 && x - 2 < N && y >= 0 && y < N)
                        map[x - 2][y] += (map[x - 1][y] - temp); //a로 날아감
                    else result += (map[x - 1][y] - temp);
                    map[x - 1][y] = 0;
                    x--;
                    break;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
        //System.out.println(result);

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
            }
        }
        to(0, 1);
        System.out.println(result);
    }
}