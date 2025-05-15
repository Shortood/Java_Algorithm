import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int MAX = 100001;
        int N = onboard.length;
        int dp[][] = new int[N][51]; //[시간][온도];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i], MAX);
        }
        
        //범위 조정
        temperature+=10;
        t1+=10;
        t2+=10;
        
        //시작 [0][temperature]
        dp[0][temperature]=0;
        
        for(int i=0;i<N-1;i++) { //시간
            int s=0, e=0;
            // 손님 없을 경우
            if(onboard[i]==0) {
                s=Math.min(t1, temperature);
                e=Math.max(t2, temperature);
            } else { // 손님 있을 경우
                s=t1;
                e=t2;
            }
            
            for(int t=s;t<=e;t++){ //온도
                if(onboard[i] ==1 && (t < t1 || t > t2))
                    continue;
                
                //에어컨 켬
                if(t<50) { //온도 올림
                    dp[i+1][t+1] = Math.min(dp[i+1][t+1], dp[i][t]+a);
                }
                
                if(t>0) { //온도 내림
                    dp[i+1][t-1] = Math.min(dp[i+1][t-1], dp[i][t]+a);
                }
                //온도 유지
                dp[i+1][t]= Math.min(dp[i+1][t], dp[i][t] + b);

                //에어컨 끔
                if(t < temperature && t<50) { //온도 올림
                    dp[i+1][t+1] = Math.min(dp[i+1][t+1], dp[i][t]);
                } else if(t > temperature && t>0) { //온도 내림
                    dp[i+1][t-1] = Math.min(dp[i+1][t-1], dp[i][t]);
                } else {
                    dp[i+1][t] = Math.min(dp[i+1][t], dp[i][t]);
                }
                
            }
                
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int i=0;i<=50;i++){
            if(answer>dp[N-1][i]){
                if(onboard[N-1]==1 && (i <t1 || i > t2))
                    continue;
                 answer=dp[N-1][i];
            }
               
        }
        
        return answer;
    }
}