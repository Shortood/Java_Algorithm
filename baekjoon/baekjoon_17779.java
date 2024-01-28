import java.util.Scanner;

class Main {
    static int N, d1, d2;
    static int[] precinct = new int[5];
    static int[][] map;
    static int[][] per;

    public static int div_per(int x, int y) {
        int result = Integer.MAX_VALUE;
        int temp;
        for (d1 = 1; d1 <= y; d1++) {
            for (d2 = 1; d2 <= N - y - 1; d2++) {
                if (x + d1 + d2 < N) {
                    temp = calculate(x, y);
                    if (result > temp)
                        result = temp;
                }
            }
        }

        return result;
    }

    public static int calculate(int x, int y) {
        int max, min;
        for (int i = 0; i < 5; i++)
            precinct[i] = 0;

        per[x][y] = -1;
        int first = y, second = y;
        int temp_d1 = d1, temp_d2 = d2;
        for (int i = x + 1; i <= x + d1 + d2; i++) {
            if (temp_d1 > 0) first--;
            else first++;
            if (temp_d2 > 0) second++;
            else second--;
            temp_d1--;
            temp_d2--;
            for (int j = first; j <= second; j++) {
                per[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (per[i][j] == -1) {
                    precinct[4] += map[i][j];
                    per[i][j] = 5;
                } else if (i < x + d1 && j <= y) {
                    precinct[0] += map[i][j];
                    per[i][j] = 1;
                } else if (i <= x + d2 && j > y) {
                    precinct[1] += map[i][j];
                    per[i][j] = 2;
                } else if (i >= x + d1 && j < y - d1 + d2) {
                    precinct[2] += map[i][j];
                    per[i][j] = 3;
                } else if (i > x + d2 && j >= y - d1 + d2) {
                    precinct[3] += map[i][j];
                    per[i][j] = 4;
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(per[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
        max = precinct[0];
        min = precinct[0];
        for (int i = 1; i < 5; i++) {
            max = Math.max(max, precinct[i]);
            min = Math.min(min, precinct[i]);
        }
        return (max - min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][];
        per = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[N];
            per[i] = new int[N];
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                per[i][j] = 0;
            }
        }
        int result = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 1; j < N - 1; j++) {
                temp = div_per(i, j);
                if (temp < result) result = temp;
            }
        }
        System.out.println(result);
    }
}