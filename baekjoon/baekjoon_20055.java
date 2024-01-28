import java.util.Scanner;
import java.util.Vector;

class Main {
    static int N, K, cnt = 0, level = 1;
    static int up, down;
    static int[] A;
    static Boolean[] isRobot;
    static Vector<Integer> robot = new Vector<Integer>();

    public static void Rotate() {
        up--;
        if (up < 0) up = 2 * N - 1;
        down--;
        if (down < 0) down = 2 * N - 1;
        if (isRobot[down] == true) {
            robot.remove(0);
            isRobot[down] = false;
        }
        moveRobot();
    }

    public static void moveRobot() {
        if (!robot.isEmpty()) {
            for (int i = 0; i < robot.size(); i++) {
                //로봇 이동 가능
                int nextLocation = (robot.get(i) + 1) % (2 * N);
                if (isRobot[nextLocation] == false && A[nextLocation] > 0) {
                    robot.set(i, nextLocation);
                    isRobot[nextLocation] = true;

                    if (nextLocation == 0)
                        isRobot[2 * N - 1] = false;
                    else
                        isRobot[nextLocation - 1] = false;

                    A[nextLocation]--;
                    if (A[nextLocation] == 0) cnt++;
                }
            }
        }

        if (isRobot[down] == true) {
            isRobot[down] = false;
            robot.remove(0);
        }
        addRobot();
    }

    public static void addRobot() {
        if (A[up] > 0) {
            isRobot[up] = true;
            robot.add(up);
            A[up]--;
            if (A[up] == 0) cnt++;
        }
        if (cnt < K) {
            level++;
            Rotate();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        A = new int[2 * N];
        isRobot = new Boolean[2 * N];
        up = 0;
        down = N - 1;
        for (int i = 0; i < 2 * N; i++) {
            A[i] = sc.nextInt();
            isRobot[i] = false;
        }
        Rotate();
        System.out.println(level);
    }
}
