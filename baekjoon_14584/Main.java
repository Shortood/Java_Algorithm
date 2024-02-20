import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int N = Integer.parseInt(br.readLine());
        String[] dic = new String[N];

        for (int i = 0; i < N; i++) {
            dic[i] = br.readLine();
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < N; j++) {
                if (check(input, dic[j])) {
                    System.out.println(input);
                    System.exit(0);
                }
            }
            for (int j = 0; j < input.length; j++) {
                input[j] = (char) ((input[j] - 96) % 26 + 97);
            }
        }
    }

    static boolean check(char[] str1, String str2) {
        int j;
        for (int i = 0; i <= str1.length - str2.length(); i++) {
            if (str1[i] == str2.charAt(0)) {
                for (j = 0; j < str2.length(); j++) {
                    if (str1[i + j] != str2.charAt(j))
                        break;
                }
                if (j == str2.length())
                    return true;
            }
        }
        return false;
    }
}