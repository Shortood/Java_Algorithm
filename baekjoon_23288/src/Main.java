import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, K, result = 0, dice = 6;
    static int x = 0, y = 0;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] map;
    static Boolean[][] visit;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int BFS(int x, int y, int val, int score) {
        //System.out.println("BFS x : " + x + " y : " + y + " val : " + val);

        queue.poll();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M)
                if (map[nx][ny] == val && visit[nx][ny] == false) { //같다
                    visit[nx][ny] = true;
                    queue.add(new Pair(x + dx[i], y + dy[i]));
                }
        }
        if (!queue.isEmpty())
            return BFS(queue.peek().x, queue.peek().y, val, score + 1);
        System.out.println("Score : " + score);
        return score;
    }

    //동 0, 남 1, 서 2, 북 3
    static void move(int dir, int index) {
        System.out.println("MOVE dir : " + dir + " index : " + index);
        System.out.println(x + " " + y);
        if (index == K) return;

        int nx = x + dx[dir]; //다음 위치
        int ny = y + dy[dir];

        if (!(nx >= 0 && ny >= 0 && nx < N && ny < M)) { //이동 불가능
            System.out.println("이동 불가능");
            nx -= 2 * dx[dir]; //반대
            ny -= 2 * dy[dir];
            dir = (dir + 2) % 4;
        }

        dice = checkDice(dice, dir); //주사위
        System.out.println("dice : " + dice);
        //System.out.println(map[nx][ny]);
        queue.add(new Pair(nx, ny));
        System.out.println("BFS " + nx + " " + ny);
        visit[nx][ny] = true;
        result += map[nx][ny] * BFS(nx, ny, map[nx][ny], 1); //점수 획득
        System.out.println("after dir " + dir);
        x = nx;
        y = ny;
        if (map[x][y] < dice)
            dir = (dir + 1) % 4;
        else if (map[x][y] > dice)
            dir = (dir + 3) % 4;

        initVisit();
        move(dir, index + 1);
    }

    private static void initVisit() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                visit[i][j] = false;
    }

    //동 0, 남 1, 서 2, 북 3
    static int checkDice(int val, int dir) {
        switch (val) {
            case 1:
                switch (dir) {
                    case 0:
                        return 4;
                    case 1:
                        return 5;
                    case 2:
                        return 3;
                    case 3:
                        return 2;
                }
            case 2:
                switch (dir) {
                    case 0:
                        return 4;
                    case 1:
                        return 1;
                    case 2:
                        return 3;
                    case 3:
                        return 6;
                }
            case 3:
                switch (dir) {
                    case 0:
                        return 2;
                    case 1:
                        return 1;
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                }
            case 4:
                switch (dir) {
                    case 0:
                        return 5;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 6;
                }
            case 5:
                switch (dir) {
                    case 0:
                        return 3;
                    case 1:
                        return 1;
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                }
            case 6:
                switch (dir) {
                    case 0:
                        return 3;
                    case 1:
                        return 5;
                    case 2:
                        return 4;
                    case 3:
                        return 2;
                }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][];
        visit = new Boolean[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[M];
            visit[i] = new Boolean[M];
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                visit[i][j] = false;
            }
        }
        move(0, 0);
        System.out.println(result);

    }
}

