import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, K, result = 0;
    static int x = 0, y = 0;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int[][] map, dice = {{0, 2, 0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}};
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
        queue.poll();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M)
                if (map[nx][ny] == val && visit[nx][ny] == false) { //같다
                    visit[nx][ny] = true; //방문 처리
                    queue.add(new Pair(x + dx[i], y + dy[i]));
                }
        }
        if (!queue.isEmpty())
            return BFS(queue.peek().x, queue.peek().y, val, score + 1);
        return score;
    }

    //동 0, 남 1, 서 2, 북 3
    static void move(int dir, int index) {

        if (index == K) return;

        int nx = x + dx[dir]; //다음 위치
        int ny = y + dy[dir];

        if (!(nx >= 0 && ny >= 0 && nx < N && ny < M)) { //이동 불가능
            nx -= 2 * dx[dir]; //반대로 가도록
            ny -= 2 * dy[dir];
            dir = (dir + 2) % 4;
        }

        checkDice(dir); //주사위 이동

        queue.add(new Pair(nx, ny)); //현재 아래 미리 추가
        visit[nx][ny] = true; //방문 처리
        result += map[nx][ny] * BFS(nx, ny, map[nx][ny], 1); //점수 획득

        x = nx; //위치 이동
        y = ny;
        if (map[x][y] < dice[3][1]) //방향 바꾸기
            dir = (dir + 1) % 4;
        else if (map[x][y] > dice[3][1])
            dir = (dir + 3) % 4;

        initVisit(); //방문 처리 초기화
        move(dir, index + 1);
    }

    private static void initVisit() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                visit[i][j] = false;
    }

    //동 0, 남 1, 서 2, 북 3
    static void checkDice(int dir) { //주사위 이동
        int temp;
        switch (dir) {
            case 0:
                temp = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = dice[1][2];
                dice[1][2] = temp;
                break;
            case 1:
                temp = dice[0][1];
                dice[0][1] = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = temp;
                break;
            case 2:
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 3:
                temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
        }
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

