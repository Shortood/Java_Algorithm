import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] a;
    static int[] score = new int[1001];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        int N;

        N = Integer.parseInt(br.readLine());

        a = new int[N][2];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        //점수 순서대로 정렬
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o2[1] - o1[1];
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < N; i++) {
            for (int j = a[i][0]; j > 0; j--) {
                //현재 마감일에 할 과제가 없다면
                if (score[j] == 0) {
                    score[j] = a[i][1];
                    result += a[i][1];
                    break;
                }
            }
        }

        System.out.println(result);
    }

}