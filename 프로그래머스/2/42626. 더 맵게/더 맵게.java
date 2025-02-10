import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(scoville);
        
        if(scoville[0] >= K)
            return 0;
        
        for(int s : scoville) {
            pq.add(s);
        }
        
        int cnt = 0;
        
        while(pq.size() >= 2){
            int first = pq.remove();
            if(first >= K) 
                return cnt;
            
            int second = pq.remove();
            int newFood = first + (second * 2);
            cnt++;
            pq.add(newFood);
        }
        
        if(pq.peek() >= K)
            return cnt;
        
        return -1;
    }
}