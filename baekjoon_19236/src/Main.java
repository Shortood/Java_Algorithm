import java.util.Scanner;

public class Main {
    static Pair[][] map = new Pair[4][4];

    public static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public static void main(String[] args) {
        int num, dir;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num = sc.nextInt();
                dir = sc.nextInt();
                map[i][j] = new Pair(num, dir);
            }
        }

    }
}