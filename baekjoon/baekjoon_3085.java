import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static String[][] n;
    static int N;

    public static void main(String[] args) throws IOException {

        String input;
        int result, max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        n = new String[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            n[i] = input.split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && n[i][j] != n[i][j + 1]) {
                    // 오른쪽 값과 바꾼 후
                    swap(n, i, j, i, j + 1);
                    result = sol(n); // 사탕 수 구하기
                    if (result > max)
                        max = result;
                    // 다시 복구
                    swap(n, i, j, i, j + 1);
                }
                if (i + 1 < N && n[i][j] != n[i + 1][j]) {
                    //아래 값과 바꿈
                    swap(n, i, j, i + 1, j);
                    result = sol(n);
                    if (result > max)
                        max = result;
                    swap(n, i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);
    }

    public static int sol(String[][] n) {
        int row, col, result = 1;
        for (int i = 0; i < N; i++) {
            row = 1; //행(가로)
            col = 1; //열(세로)
            for (int j = 1; j < N; j++) {
                if (n[i][j].equals(n[i][j - 1]))
                    row++;
                else
                    row = 1;
                if (n[j][i].equals(n[j - 1][i]))
                    col++;
                else
                    col = 1;
                if (row > result)
                    result = row;
                if (col > result)
                    result = col;
            }
        }
        return result;
    }

    public static void swap(String[][] n, int x1, int y1, int x2, int y2) {
        String temp = n[x1][y1];
        n[x1][y1] = n[x2][y2];
        n[x2][y2] = temp;
    }
}