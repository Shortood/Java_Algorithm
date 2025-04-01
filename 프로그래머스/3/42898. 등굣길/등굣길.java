import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] map = new boolean[m+1][n+1];
        int[][] dp = new int[m+1][n+1];
        
        for(int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = true;
        }
        
        dp[1][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(!map[i][j])
                    dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
                //System.out.println("i = " + i + "j = " + j + " = " + dp[i][j]);
            }
        }
        
        return dp[m][n];
    }
}