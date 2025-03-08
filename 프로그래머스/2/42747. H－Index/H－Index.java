import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int cur;
        
        for(cur = 0 ; cur<=citations[citations.length-1];cur++){
            int cnt = 0;
            for(int i=citations.length -1 ;i>=0;i--){
                if(citations[i]>=cur)
                    cnt++;
                else
                    break;
            }

            if(cnt<cur)
                break;
        }
        
        
        return cur-1;
    }
}