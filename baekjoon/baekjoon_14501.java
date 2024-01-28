import java.util.Scanner;

class Main {
    static int N, result = 0;
    static int[] T, P, DP;

    public static void BP(int total, int index) {
        if (total > result) result = total;
        if (index >= N) return;

        if (index + T[index] - 1 < N) //해당 날짜 상담 하는 경우
            BP(total + P[index], index + T[index]);

        if (index + 1 < N) //하지 않는 경우
            BP(total, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        DP = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        BP(0, 0);

        System.out.println(result);
    }
}
