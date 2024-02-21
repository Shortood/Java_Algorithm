import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = 0;
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("IO");
        }
        sb.append("I");
        String str = sb.toString();
        System.out.println("str = " + str);
        while (true) {

            int index = input.indexOf(str);
            if (index >= 0)
                result++;
            else
                break;
            input = input.substring(index + 1);
        }
        System.out.println(result);

    }
}