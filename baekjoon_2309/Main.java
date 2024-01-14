import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] n = new int[9];

    public static void main(String[] args) throws IOException {
        int sum = 0, value;
        int i, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (i = 0; i < 9; i++) {
            n[i] = Integer.parseInt(br.readLine());
            sum += n[i];
        }

        value = sum - 100;
        Arrays.sort(n);

        for (i = 0; i < 8; i++) {
            for (j = i + 1; j < 9; j++) {
                if (i != j && (n[i] + n[j]) == value) {
                    printResult(n, i, j);
                    return;
                }
            }
        }
    }

    public static void printResult(int[] n, int i, int j) {
        for (int p = 0; p < 9; p++) {
            if (p != i && p != j)
                System.out.println(n[p]);
        }
    }
}
