import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, num, sum;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        N = Integer.parseInt(input);

        for (int i = N - 9 * input.length(); i < N; i++) {
            num = i;
            sum = i;
            while (num > 0 && sum <= N) {
                sum += (num % 10);
                num = num / 10;
            }
            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}