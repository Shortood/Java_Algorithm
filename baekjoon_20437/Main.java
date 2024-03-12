//문자 입력받을때 하나씩 보면서 각 알파벳 위치 저장
// 갯수 저장
// 갯수가 T개 이상인 애들만 확인
// 저장한 위치 사이값 비교

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] al = new int[26];
        List<Integer>[] list = new ArrayList[26];

        int K;
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < 26; i++)
                list[i] = new ArrayList<>();

            int min = 10000, max = -1;
            String W = br.readLine();
            K = Integer.parseInt(br.readLine());
            for (int i = 0; i < W.length(); i++) {
                al[W.charAt(i) - 'a']++;
                list[W.charAt(i) - 'a'].add(i);
            }

            for (int i = 0; i < 26; i++) {
                if (al[i] >= K) {
                    for (int j = K - 1; j < list[i].size(); j++) {
                        int val = list[i].get(j) - list[i].get(j - K + 1) + 1;
                        min = Math.min(min, val);
                        max = Math.max(max, val);
                    }
                }
            }
            if (max == -1)
                sb.append("-1\n");
            else
                sb.append(min + " " + max + "\n");
            Arrays.fill(al, 0);
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}