import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int L, P, V;
        int cnt = 0;

        while (true) {
            cnt++;
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if ((L == 0 && P == 0 && V == 0))
                return;
            System.out.println("Case " + cnt + ": " + (L * (V / P) + Math.min(V % P, L)));
        }
    }
}