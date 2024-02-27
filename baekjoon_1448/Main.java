import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] stick = new Integer[N];
        for (int i = 0; i < N; i++) {
            stick[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(stick);
        for (int i = N - 1; i >= 2; i--) {
            if (stick[i] < stick[i - 1] + stick[i - 2]) {
                System.out.println((stick[i] + stick[i - 1] + stick[i - 2]));
                return;
            }
        }
        System.out.println(-1);

    }
}