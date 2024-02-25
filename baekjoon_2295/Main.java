import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());

        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(num[i] + num[j]);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (set.contains(num[i] - num[j])) {
                    System.out.println(num[i]);
                    return;
                }
            }
        }

    }
}