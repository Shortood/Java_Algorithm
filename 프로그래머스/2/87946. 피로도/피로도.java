import java.io.*;

class Solution {
    static int N, answer;
    static boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        check = new boolean[N];
        
        for(int i=0;i < N;i++){
            if(dungeons[i][0]<=k){
                check[i]=true;
                dfs(dungeons, k-dungeons[i][1], 1);
                check[i]=false;
            }
        }
        return answer;
    }
    
    static void dfs(int[][] dungeons, int nowK, int cnt){
        //System.out.println(depth + " " + nowK + " " + cnt);
        answer = Math.max(answer, cnt);
        
        for(int i=0;i<N;i++) {
            if(!check[i]&&nowK>=dungeons[i][0]) {
                check[i]=true;
                dfs(dungeons, nowK-dungeons[i][1], cnt + 1);
                check[i]=false;
            }
        }
    }
}