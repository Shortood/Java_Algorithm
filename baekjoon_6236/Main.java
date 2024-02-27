import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());

        int[] price = new int[N];
        int end = 0;
        int start = 0;
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(br.readLine());
            if (price[i] > start)
                start = price[i];
            end += price[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int money = 0;
            int cnt = 0;
            
            for (int i = 0; i < N; i++) {
                if (money - price[i] < 0) {
                    cnt++;
                    money = mid - price[i];
                } else
                    money -= price[i];
            }

            if (cnt > M)
                start = mid + 1;
            else
                end = mid - 1;
        }
        System.out.println(start);
    }
}