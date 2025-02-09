import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] remain = new int[progresses.length];
        int cnt = 1;
        int maxDay = -1;
        
        List<Integer> list = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            remain[i]=(100-progresses[i])/speeds[i];
            
            if((100-progresses[i])%speeds[i] > 0)
                remain[i]++;
            
            if(remain[i] <= maxDay)
                cnt++;
            else {
                if(maxDay!=-1)
                    list.add(cnt);
                cnt = 1;
                maxDay = remain[i];
            }
            //System.out.println(remain[i]);
        }

    
        
        list.add(cnt);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}