// 루트는 무조건 1
// 루트부터 p 부모까지는 작은 수
// 리프부터 p 자식 까지는  n부터 작아지는 값
// 나머지는 비어있는 노드에 순차적으로 커지도록 넣음
// 수 넣으면서 확인

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, downnum, num, upnum;
    static int[] heap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heap = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
        int now = p / 2;
        upnum = k - 1; // 부모에 넣을 수-> min이 저장됨

        // 부모 작은 수들 넣기
        while (now >= 1) {
            if (upnum < 1) { // 넣을 수 없다면
                System.out.println("-1");
                return;
            }
            heap[now] = upnum;
            upnum--;
            now /= 2;
        }

        // 자손들 큰 수들 넣기
        downnum = k - 1; // max 값 저장됨
        dfs(p);

        // 나머지 수들 빈 칸에 넣기
        num = 1;
        for (int i = 1; i <= N; i++) {
            // 이미 썼던 수는 안씀
            // upnum은 k-1부터 적어지도록
            // downnum은 k부터 커지더록 썻으므로 이 사이값은 안씀
            if (num > upnum && num <= downnum)
                num = downnum + 1;
            if (heap[i] == 0) { // 아직 안 넣음
                heap[i] = num;
                upheap(i);
                num++;
            }
        }

        // 이거 안쓰면 시간 초과남
        for (int i = 1; i <= N; i++)
            sb.append(heap[i] + " ");
        System.out.println(sb);
    }

    static void dfs(int index) {
        downnum++;
        if (downnum > N) {
            System.out.println("-1");
            System.exit(0);
        }
        heap[index] = downnum;

        if (index * 2 <= N)
            dfs(index * 2);
        if (index * 2 < N)
            dfs(index * 2 + 1);
    }

    static void upheap(int id) {
        while (id > 1) {
            if (heap[id / 2] <= heap[id])
                break;
            swap(heap[id], heap[id / 2]);
            id = id / 2;
        }
    }

    static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
}