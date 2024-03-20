import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//((()[]))

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int result = 0, temp = 1;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(2);
                temp *= 2;
            } else if (input.charAt(i) == '[') {
                stack.push(3);
                temp *= 3;
            } else if (input.charAt(i) == ')' && !stack.isEmpty()) {
                if (stack.peek() == 2) {
                    stack.pop();
                    if (input.charAt(i - 1) == '(')
                        result += temp;
                    temp /= 2;
                } else {
                    System.out.println(0);
                    return;
                }
            } else if (input.charAt(i) == ']' && !stack.isEmpty()) {
                if (stack.peek() == 3) {
                    stack.pop();
                    if (input.charAt(i - 1) == '[')
                        result += temp;
                    temp /= 3;
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(result);
    }
}
// 1
// 4 22