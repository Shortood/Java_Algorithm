import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1700 {
    static int N, K;
    static int[] a, plug;

    public static void main(String[] args) throws IOException {
        String input;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        input = br.readLine();
        st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        plug = new int[N]; // 플러그 상태
        a = new int[K]; // 입력

        int t;
        input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 0; i < K; i++) {
            t = Integer.parseInt(st.nextToken());
            a[i] = t;
        }

        int i = 0;
        while (i < K) {
            if (!checkPlug(a[i])) { // 같은 번호가 플러그에 없을 때
                int change = choosePlug(i + 1);
                if (plug[change] != 0) { // 플러그를 바꿔야 할 때
                    result++;
                }
                plug[change] = a[i]; // 플러그 변경
            }

            i++;
        }

        System.out.println(result);
    }

    // 이미 같은 제품이 플러그에 있는지 확인
    public static boolean checkPlug(int a) {
        for (int i = 0; i < N; i++) {
            if (plug[i] == a)
                return true;
        }
        return false;
    }

    // 바꿀 플러그 확인
    public static int choosePlug(int next) {
        int result = 0, temp = 0, j;
        for (int i = 0; i < N; i++) {
            if (plug[i] == 0) // 빈 플러그가 있다면 선택
                return i;

            // 가장 먼저 사용되는 인덱스
            for (j = next; j < K; j++) {
                if (plug[i] == a[j])
                    break;
            }

            //더 늦게 사용되는 상품 저장
            if (j > temp) {
                temp = j;
                result = i;
            }
        }

        return result;
    }
}