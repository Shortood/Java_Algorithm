import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int N, result = 0;
    static String[] str;
    static Integer[] alp = new Integer[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 0 초기화
        Arrays.fill(alp, 0);
        str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < str[i].length(); j++) {
                // 각 알파벳 총 수 구하기
                alp[str[i].charAt(j) - 'A'] += (int) Math.pow(10, str[i].length() - j - 1);
            }
        }

        Arrays.sort(alp, Comparator.reverseOrder());
        // 가장 큰놈 가장 큰 숫자
        for (int i = 0; i <= 10; i++) {
            result += alp[i] * (9 - i);
        }
        System.out.println(result);

    }
}