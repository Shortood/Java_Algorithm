import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, K, result;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0};

    static ArrayList<piece> pieces = new ArrayList<piece>();

    public static class piece {
        int x, y;
        int dir;
        int upIndex;

        public piece(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.upIndex = -1;
        }
    }

    public static void move(int cnt) {
        int nx, ny;
        if (cnt >= 1000) {
            result = -1;
            return;
        }
        //1 오 2 왼 3위 4 아래
        for (int i = 0; i < pieces.size(); i++) {
            int pi = i;
            nx = pieces.get(i).x + dx[pieces.get(i).dir];
            ny = pieces.get(i).y + dy[pieces.get(i).dir];
            System.out.println();
            System.out.println(i + " nx = " + nx + " ny = " + ny);
            if (!(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 2)) { //파란색 or 범위 밖
                System.out.println("밖");
                nx = pieces.get(i).x - dx[pieces.get(i).dir];
                ny = pieces.get(i).y - dy[pieces.get(i).dir];
            }

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 2) { //범위 안
                if (map[nx][ny] == 1) //빨간색
                    pi = setReverse(i); //뒤집어줌
                move(nx, ny, pi);
                int c = count(nx, ny);
                System.out.println(" c " + c);
                if (c >= 4) {
                    result = cnt;
                    return;
                }
            }

        }
        move(cnt + 1);
    }

    public static void move(int nx, int ny, int i) {
        int pre = findPrevious(i);//i번 아래에 있는 말 찾기
        System.out.println("move to " + i + " " + nx + " " + ny);
        int ni = find(nx, ny); //갈 곳에 있는 말 번호

        if (ni != -1) { //갈 곳에 말이 있음
            while (pieces.get(ni).upIndex != -1)  //가장 위 찾기
                ni = pieces.get(ni).upIndex;
            pieces.get(ni).upIndex = i;
        }
        System.out.println("ni = " + ni);
        System.out.println("pre = " + pre);
        if (pre != -1)
            pieces.get(pre).upIndex = -1;

        setPlace(i, nx, ny); //위치 바꾸기
    }


    public static int find(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).x == x && pieces.get(i).y == y)
                return i;
        }
        return -1;
    }

    public static int findPrevious(int index) {
        System.out.println("findPrevious = " + index);
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).upIndex == index)
                return i;
        }
        return -1;
    }

    public static int count(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).x == x && pieces.get(i).y == y)
                cnt++;
        }
        return cnt;
    }

    public static int setReverse(int index) { //2
        System.out.println("setReverse = " + index);
        int next, now = index, pre = index;
        int pi = findPrevious(index);//i번 아래에 있는 말 찾기

        next = pieces.get(index).upIndex;
        System.out.println("next = " + next);
        pieces.get(index).upIndex = -1;
        System.out.println(index + " up = " + -1);
        while (next != -1) {
            now = next; //0 1
            System.out.println(index + " => " + next);
            next = pieces.get(now).upIndex; //1 -1
            System.out.println("next = " + pieces.get(now).upIndex);
            pieces.get(now).upIndex = pre; //2
            System.out.println("now =>" + pre);
            pre = now;
            System.out.println("pre =" + now);
        }
        if (pi != -1)
            pieces.get(pi).upIndex = now;
        return now;
    }

    public static void setPlace(int index, int nx, int ny) {
        System.out.println("setPlace " + index + " " + nx + " " + ny);
        pieces.get(index).x = nx;
        pieces.get(index).y = ny;
        if (pieces.get(index).upIndex != -1)
            setPlace(pieces.get(index).upIndex, nx, ny);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[N];
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++)
            pieces.add(new piece(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));

        move(1);
        System.out.println(result);
    }
}
