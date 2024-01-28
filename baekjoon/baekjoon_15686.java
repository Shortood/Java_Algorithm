import java.util.Scanner;
import java.util.Vector;

class Main {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] map;
    static Boolean[] visit;
    static Vector<Pair> home = new Vector<Pair>();
    static Vector<Pair> chicken = new Vector<Pair>();

    static class Pair {
        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }
    }

    public static void getSelect(int index, int count) {
        int distance;
        if (count == M) {
            distance = getDistance();
            if (result > distance)
                result = distance;
        } else {
            for (int i = index; i < chicken.size(); i++) {
                if (visit[i] == Boolean.FALSE) {
                    visit[i] = Boolean.TRUE;
                    getSelect(i, count + 1);
                    visit[i] = Boolean.FALSE;
                }
            }
        }
    }

    public static int getDistance() {
        int totaldistance = 0;
//        for (int i = 0; i < visit.length; i++) {
//            System.out.print(visit[i] + " ");
//        }
        System.out.println();
        for (int i = 0; i < home.size(); i++) {
            int distance = Integer.MAX_VALUE, temp;
            for (int j = 0; j < chicken.size(); j++) {
                if (visit[j] == Boolean.TRUE) {
                    temp = Math.abs(home.get(i).getFirst() - chicken.get(j).getFirst())
                            + Math.abs(home.get(i).getSecond() - chicken.get(j).getSecond());
                    if (distance > temp) distance = temp;
                }
            }
            totaldistance += distance;
        }
        return totaldistance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][];

        for (int i = 0; i < N; i++) {
            map[i] = new int[N];
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) home.add(new Pair(i, j));
                else if (map[i][j] == 2) chicken.add(new Pair(i, j));
            }
        }
        visit = new Boolean[chicken.size()];

        for (int i = 0; i < visit.length; i++) {
            visit[i] = Boolean.FALSE;
        }

        getSelect(0, 0);
        System.out.println(result);
    }
}