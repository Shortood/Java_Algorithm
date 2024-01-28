import java.util.Scanner;

class Main {
    static int N;

    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = N / 5;
        do {
            b = N - a * 5;
            if (b % 3 == 0) break;
            a--;
        } while (a >= 0);
        if (a >= 0) System.out.println(a + b / 3);
        else System.out.println("-1");
    }
}
