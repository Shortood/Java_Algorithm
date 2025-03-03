import java.util.*;

class Solution {
    static boolean[][] map;
    static boolean[] check;
    static int cnt;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new boolean[n+1][n+1];

        for(int[] wire : wires) {
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire : wires) {
            check = new boolean[n+1];
            cnt = 0;
            map[wire[0]][wire[1]] = false;
            map[wire[1]][wire[0]] = false;
            dfs(wire[0]);
            answer=Math.min(answer, Math.abs(cnt - (n-cnt)));
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }
        
        
        return answer;
    }
    
    void dfs(int now) {
        cnt++;
        check[now] = true;
        for(int i=1;i<check.length;i++){
            if(map[now][i] == true && !check[i]) {
                dfs(i);
            }
        }
    }
}