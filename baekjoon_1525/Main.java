import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };
        Map<String, Integer> map = new HashMap<String, Integer>();
        String str = "";
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            str += st.nextToken();
            str += st.nextToken();
            str += st.nextToken();
        }

        map.put(str, 0);
        queue.offer(str);

        while (!queue.isEmpty()) {
            str = queue.remove();
            int cnt = map.get(str);
            if (str.equals("123456780")) {
                System.out.println(cnt);
                return;
            }
            // i = index/3, j = index%3
            for (int i = 0; i < 4; i++) {
                int index = str.indexOf('0');
                int x = index / 3;
                int y = index % 3;
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    // 다음 0의 인덱스
                    int nindex = nx * 3 + ny;
                    // 0과 바꿀 문자
                    char ch = str.charAt(nindex);
                    // 바꿈
                    String nString = str.replace(ch, 'a');
                    nString = nString.replace('0', ch);
                    nString = nString.replace('a', '0');
                    if (!map.containsKey(nString)) {
                        map.put(nString, cnt + 1);
                        queue.offer(nString);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}