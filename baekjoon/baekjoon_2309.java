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
            sum += n[i]; // 난쟁이 키 합
        }

        value = sum - 100; // 100을 뺀 값

        for (i = 0; i < 8; i++) {
            for (j = i + 1; j < 9; j++) {
                if (i != j && (n[i] + n[j]) == value) { // 난쟁이의 키의 합이 같은 경우
                    //제외할 두 난쟁이 키를 100
                    n[i] = 100;
                    n[j] = 100;
                    //정렬
                    Arrays.sort(n);
                    printResult(n);
                    return;
                }
            }
        }
    }

    // 결과 출력
    public static void printResult(int[] n) {
        for (int p = 0; p < 7; p++) { //7명만 출력
            System.out.println(n[p]);
        }
    }
}
