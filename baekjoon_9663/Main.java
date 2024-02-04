import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sol(0);
        System.out.println(result);
    }

    static void sol(int cnt) {
        if (cnt == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[cnt] = i; // i번째에 놔둠
            if (check(cnt)) { // true면 가능
                sol(cnt + 1);
            }
        }
    }

    static boolean check(int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (arr[cnt] == arr[i])
                return false;
            else if (Math.abs(cnt - i) == Math.abs(arr[cnt] - arr[i])) //기울기가 1
                return false;
        }
        return true;
    }
}