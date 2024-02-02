import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, result;
    static int[] student;
    static boolean[] visit, done;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            done = new boolean[N + 1];
            visit = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                student[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                if (visit[i] == false)
                    dfs(i);
            }
            System.out.println(N - result);

        }
    }

    static void dfs(int s) {
        visit[s] = true;

        if (visit[student[s]] == false) // 다음 학생 방문 X
            dfs(student[s]);
        // 방문은 했지만 사이클은 안 만들어짐
        else if (done[student[s]] == false) {
            //사이클 처리
            for (int i = student[s]; i != s; i = student[i])
                result++;
            result++;
        }
        // 일단 끝 처리
        done[s] = true;
    }
}