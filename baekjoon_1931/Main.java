import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
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
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int finishTime = a[0][1];

        for (int i = 1; i < N; i++) {
            if (a[i][0] >= finishTime) {
                result++;
                finishTime = a[i][1];
            }
        }

        System.out.println(result);

    }
}