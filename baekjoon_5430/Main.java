import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            boolean isReverse = false, flag = true;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            if (input.length() > 2) {
                String[] numInputs = input.substring(1, input.length() - 1).split(",");
                for (int i = 0; i < numInputs.length; i++) {
                    deque.add(Integer.parseInt(numInputs[i]));
                }
            }

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    if (isReverse)
                        isReverse = false;
                    else
                        isReverse = true;
                } else if (p.charAt(i) == 'D') {
                    if (deque.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (isReverse)
                        deque.removeLast();
                    else
                        deque.removeFirst();
                }
            }
            if (flag) {
                if (deque.isEmpty()) {
                    sb.append("[]\n");
                } else {
                    sb.append("[");
                    if (isReverse) {
                        while (deque.size() > 1)
                            sb.append(deque.removeLast() + ",");
                    } else {
                        while (deque.size() > 1)
                            sb.append(deque.removeFirst() + ",");
                    }
                    sb.append(deque.remove() + "]\n");
                }
            } else
                sb.append("error\n");
        }

        System.out.print(sb);
    }
}