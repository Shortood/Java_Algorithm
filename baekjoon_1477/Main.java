import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] building = new int[N + 2];

        for (int i = 1; i <= N; i++)
            building[i] = Integer.parseInt(st.nextToken());

        building[N + 1] = L;
        Arrays.sort(building);

        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 1; i <= N + 1; i++)
                sum += (building[i] - building[i - 1] - 1) / mid;

            if (sum > M)
                left = mid + 1;
            else
                right = mid - 1;

        }
        System.out.println(left);
    }
}