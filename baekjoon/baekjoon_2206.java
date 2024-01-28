import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다음 갈 곳이 벽
//지금 까지 벽을 부쉈다 -> 못감
//안 부숨 -> 부쉈다 표시하고 부쉈을 때 visit 저장
//벽 아님
//지금 까지 벽을 부쉈다 -> 부순 visit 저장
//안 부숨 => 안 부순 visit 저장
//이미 갔으면 안감
//각각 visit 확인
//지금 까지 벽을 부쉈다 -> 부순 visit
//안 부쉈다 -> 안 부순 visit 확인

public class baekjoon_2206 {
    public static void main(String[] args) throws IOException {
        char[][] map;
        boolean[][] visit;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, result = 0;
        Queue<Pair> queue = new LinkedList<>();
        int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        queue.offer(new Pair(0, 0));

        Pair temp;
        int nx, ny;

        System.out.println(-1);

    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}