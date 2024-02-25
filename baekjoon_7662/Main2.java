import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (op.equals("I")) { // 삽입
                    if (map.containsKey(num)) // 수가 이미 있다면
                        map.put(num, map.get(num) + 1); // 1증가
                    else // 없다면
                        map.put(num, 1);
                } else if (op.equals("D")) { // 삭제
                    if (map.size() == 0)
                        continue; // 큐에 수가 없다면 무시

                    if (num == 1) {// 최대 삭제
                        Map.Entry<Integer, Integer> max = map.lastEntry();
                        if (max.getValue() == 1)
                            map.pollLastEntry();
                        else
                            map.put(max.getKey(), max.getValue() - 1);
                    } else {// 최소 삭제
                        Map.Entry<Integer, Integer> min = map.firstEntry();
                        if (min.getValue() == 1)
                            map.pollFirstEntry();
                        else
                            map.put(min.getKey(), min.getValue() - 1);
                    }
                }

            }
            if (!map.isEmpty()) {
                sb.append(map.lastKey() + " " + map.firstKey() + '\n');
            } else
                sb.append("EMPTY\n");
            map.clear();
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
