import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] money = new int[N];
        int start = 1, end = 0, sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            sum += money[i];
            if (money[i] > end)
                end = money[i];
        }

        int total = Integer.parseInt(br.readLine());
        if (sum <= total)
            System.out.println(end);
        else {
            while (start <= end) {
                sum = 0;
                int mid = (start + end) / 2;
                for (int i = 0; i < N; i++) {
                    if (money[i] <= mid)
                        sum += money[i];
                    else
                        sum += mid;
                }

                if (sum > total)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            System.out.println(start + " " + end);
        }
    }
}