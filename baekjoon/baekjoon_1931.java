import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_1931 {
    public static void main(String[] args) throws IOException {
        int N, result = 1;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] a = new int[N][2];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        // 끝나는 시간 기준으로 정렬
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) // 끝나는 시간이 같으면 시작 시간이 빠른 경우
                    return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int finishTime = a[0][1]; // 첫 회의의 끝나는 시간

        for (int i = 1; i < N; i++) { // 두번째 회의부터 확인
            if (a[i][0] >= finishTime) { // 시작 가능 하면
                result++;
                finishTime = a[i][1];
            }
        }

        System.out.println(result);

    }
}