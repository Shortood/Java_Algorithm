import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int j;

        while (true) {
            String input = br.readLine();
            if (input == null || input.length() == 0)
                break;

            st = new StringTokenizer(input);
            String input1 = st.nextToken();
            String input2 = st.nextToken();

            int cnt = 0;
            for (j = 0; j < input2.length(); j++) {
                if (input1.charAt(cnt) == input2.charAt(j))
                    cnt++;
                if (cnt >= input1.length())
                    break;
            }
            if (j >= input2.length())
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }
}