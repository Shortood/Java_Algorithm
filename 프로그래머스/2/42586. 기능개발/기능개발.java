import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] remain = new int[progresses.length];
        int cnt = 1;
        List<Integer> list = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            remain[i]=(100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]>0)
                remain[i]++;
            System.out.println(remain[i]);
        }

        int maxDay=remain[0];
        
        for(int i=1;i<remain.length;i++){
            if(remain[i]<=maxDay){
                cnt++;
            } else { 
                list.add(cnt);
                cnt = 1;
                maxDay = remain[i];
            }
        }
        
        list.add(cnt);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}