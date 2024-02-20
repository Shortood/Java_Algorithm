import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] key = br.readLine().toCharArray();
        char[] copyKey = Arrays.copyOf(key, key.length);
        Arrays.sort(copyKey);

        String input = br.readLine();

        // 정렬 순서
        int[] order = new int[key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < copyKey.length; j++) {
                if (key[i] == copyKey[j]) {
                    order[i] = j;
                    copyKey[j] = ' ';
                    break;
                }
            }
        }

        char[][] array = new char[input.length() / key.length][key.length];

        // 암호문 이차원 배열 형태로 저장
        int low = input.length() / key.length;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < low; j++) {
                int index = i * low + j;
                array[j][i] = input.charAt(index);
            }
        }

        // 정렬 순서에 맞게 추가
        for (int i = 0; i < low; i++) {
            for (int j = 0; j < key.length; j++) {
                sb.append(array[i][order[j]]);
            }
        }
        System.out.println(sb);
    }
}