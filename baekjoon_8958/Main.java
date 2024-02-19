import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            int cnt = 1;
            int score = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[j] == 'O') {
                    score += cnt;
                    cnt++;
                } else
                    cnt = 1;
            }
            System.out.println(score);
        }
    }
}