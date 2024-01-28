import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] s = new int[45];

    public static void main(String[] args) throws IOException {
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] a = new int[N];

        //삼각수 입력
        for (int i = 0; i < 45; i++)
            s[i] = (i + 1) * (i + 2) / 2;

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            
            //출력
            System.out.println(sol(a[i]));
        }

    }

    public static int sol(int n) {
        for (int i = 0; i < 45; i++) {
            for (int j = i; j < 45; j++) {
                for (int k = j; k < 45; k++) {
                    if (s[i] + s[j] + s[k] == n)
                        return 1;
                }
            }
        }
        return 0;
    }
}