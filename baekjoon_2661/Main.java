import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean flag = true;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        sol();
        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);
        }
    }

    static void sol() {
        for (int i = 1; i <= 3; i++) {
            result[0] = i;
            if (check(0, i))
                sol(1);
        }
    }

    static void sol(int index) {
        if (index == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(result[i]);
            }
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            result[index] = i;
            if (check(index, i))
                sol(index + 1);
        }
    }

    static boolean check(int index, int num) {
        int j;
        for (int i = 1; i <= (index + 1) / 2; i++) {// 갯수
            for (j = 0; j < i; j++) {
                if (result[index - j - i] != result[index - j])
                    break;
            }
            if (j >= i)
                return false;
        }
        return true;
    }
}