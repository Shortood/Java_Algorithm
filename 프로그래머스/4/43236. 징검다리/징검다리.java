import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 0, right = distance;
        
        while(left<=right) {
            int mid = (left + right)/2;
            int now = 0;
            int cnt = 0;
            //System.out.println("mid = " + mid + " cnt = " + cnt);
            // 2 11 14 17 21
            for(int i=0;i<rocks.length;i++){
                //System.out.println(rocks[i] + "  " + now);
                if(rocks[i]-now>=mid){
                    now = rocks[i];
                } else {
                    cnt++;
                }
            }
            
            if(distance - now < mid)
                cnt++;

            if(cnt<=n) {
                left=mid+1; 
                if(answer<mid)
                    answer=mid;
            }
            else
                right=mid-1;           
        }
        return answer;
    }
}