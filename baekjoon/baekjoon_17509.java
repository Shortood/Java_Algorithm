import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] a = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        int result = 0, sum = 0, pen = 0;
        for (int i = 0; i < 11; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            a[i] = Integer.parseInt(st.nextToken());
            result += (20 * Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a);
        for (int i = 0; i < 11; i++) {
            pen += a[i];
            sum += pen;
        }

        System.out.println(result + sum);
    }
}