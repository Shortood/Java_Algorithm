import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1;i<=n;i++) {
            if(!chk[i]){
                queue.add(i);
                chk[i]=true;
                answer++;
                while(!queue.isEmpty()){
                    int now = queue.remove();
                    for(int j=0;j<n;j++){
                        if(computers[now-1][j] == 1 && !chk[j+1]) { //연결되어 있음
                            chk[j+1]=true;
                            queue.add(j+1);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}