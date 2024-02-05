import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] number;
    static int[] result;
    static String input;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        number = new boolean[input.length() + 1];
        result = new int[input.length() + 1];
        sol(0, 0);
    }

    static void sol(int index, int cnt) {
        if (flag)
            return;

        if (index >= input.length()) {
            if (check(cnt)) {
                flag = true;
                print(cnt);
            }
            return;
        }
        
        if (index + 1 <= input.length()) {
            int num1 = Integer.parseInt(input.substring(index, index + 1));
            if (num1 > 0 && num1 <= input.length() && number[num1] == false) {
                number[num1] = true;
                result[cnt] = num1;
                sol(index + 1, cnt + 1);
                number[num1] = false;
            }
        }

        if (index + 2 <= input.length()) {
            int num2 = Integer.parseInt(input.substring(index, index + 2));
            if (num2 > 9 && num2 <= input.length() && number[num2] == false) {
                number[num2] = true;
                result[cnt] = num2;
                sol(index + 2, cnt + 1);
                number[num2] = false;
            }
        }

    }

    static boolean check(int cnt) {
        for (int i = 1; i <= cnt; i++) {
            if (number[i] == false)
                return false;
        }
        return true;
    }

    static void print(int cnt) {
        for (int i = 0; i < cnt; i++) {
            System.out.print(result[i] + " ");
        }
    }
}