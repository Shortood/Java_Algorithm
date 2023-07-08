import java.util.Scanner;

public class Main {
    static Pair[][] map = new Pair[4][4];

    public static class Pair {
        private int first, second;
        private boolean alive;

        public Pair(int first, int second, Boolean alive) {
            this.first = first; //번호
            this.second = second; //방향
            this.alive = alive; //생존
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public static class Shark {
        private int x, y, dir;

        public Shark(int x, int y, int dir) { //상어
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public int getDir() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void DFS(Shark shark, Pair[][] map) {

    }

    public static void main(String[] args) {
        int num, dir;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num = sc.nextInt();
                dir = sc.nextInt();
                map[i][j] = new Pair(num, dir, true);
            }
        }
        Shark shark = new Shark(0, 0, map[0][0].getSecond());
        map[0][0].alive = Boolean.FALSE;
        DFS(shark, map);
    }
}