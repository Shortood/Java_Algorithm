import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 왼쪽 부터 높이 보기
// 높이가 늘어나다 처음 줄어들 때 높이 저장
// 다음 봉우리가 이전 봉우리보다 크면 X
// 다음 봉우리가 이전 봉우리 보다 작으면 물 빼주기
public class Main2 {
    public static void main(String[] args) throws IOException {
        int H, W;
        boolean isUp = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        int height = map[0], temp = map[0];
        int result = 0, cnt = 0;
        for (int i = 1; i < W; i++) {
            //System.out.println("i = " + i);
            cnt++;

            if (map[i] >= map[i - 1]) { // 높이 증가
                isUp = true;
                temp = map[i];
            } else if (map[i] < map[i - 1] && isUp) { // 처음 줄어듬
                isUp = false;
                if (map[i - 1] < height) { // 봉우리가 이전 봉우리 보다 작다
                    //System.out.println("이전 작음");
                    result -= (cnt - 1) * (height - temp);
                }
                cnt = 1;
                height = map[i - 1]; // 이전 봉우리 저장
            }
            if (height - map[i] >= 0)
                result += height - map[i];
            //System.out.println(height + " " + result);
        }
        // 마지막도 봐줘야함
        if (map[W - 1] < height) {
            //System.out.println("작음 " + cnt + " " + height + " " + map[W - 1]);
            result -= cnt * (height - map[W - 1]);
        }

        System.out.println(result);
    }
}