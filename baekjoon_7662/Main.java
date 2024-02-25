import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 작은 수 앞
        PriorityQueue<Integer> rqueue = new PriorityQueue<>(Comparator.reverseOrder()); // 큰 수 앞
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int cnt = 0; // 큐안의 수 갯수
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (op.equals("I")) { // 삽입
                    cnt++;
                    queue.offer(num);
                    rqueue.offer(num);
                    if (map.containsKey(num)) // 수가 이미 있다면
                        map.put(num, map.get(num) + 1); // 1증가
                    else // 없다면
                        map.put(num, 1);
                } else if (op.equals("D")) { // 삭제
                    if (cnt == 0)
                        continue; // 큐에 수가 없다면 무시
                    cnt--;

                    int delNum; // 삭제한 수
                    if (num == 1) {// 최대 삭제
                        while (true) {
                            delNum = rqueue.remove();
                            if (map.containsKey(delNum))
                                break;
                        }
                    } else {// 최소 삭제
                        while (true) {
                            delNum = queue.remove();
                            if (map.containsKey(delNum))
                                break;
                        }
                    }

                    if (map.get(delNum) > 1) // 2개 이상
                        map.put(delNum, map.get(delNum) - 1); // 1 감소
                    else // 1개 있었다면
                        map.remove(delNum); // 삭제

                }
            }
            if (map.size() > 0) {
                while (true) { // 가장 큰수
                    int num = rqueue.remove();
                    if (map.containsKey(num)) {
                        sb.append(num + " ");
                        break;
                    }
                }
                while (true) { // 가장 작은수
                    int num = queue.remove();
                    if (map.containsKey(num)) {
                        sb.append(num + "\n");
                        break;
                    }
                }
            } else
                sb.append("EMPTY\n");

            queue.clear();
            rqueue.clear();
            map.clear();
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}