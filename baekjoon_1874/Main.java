import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int[] num = new int[N];
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        int index = 1;
        while (index <= N) {
            int temp = index;
            stack.push(temp); // 푸시
            sb.append("+\n");
            // +

            while (!stack.isEmpty() && stack.peek() == num[cnt]) {
                // 팝
                cnt++;
                stack.pop();
                sb.append("-\n");
                // -
            }
            index++;
        }
        if (cnt == N)
            System.out.println(sb.substring(0, sb.length() - 1));
        else
            System.out.println("NO");
    }
}