import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] priorNum = new int[10];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0;i<priorities.length;i++){
            priorNum[priorities[i]]++;
            queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int now = queue.remove();
            int i;
            
            for(i=priorities[now]+1;i<10;i++){
                if(priorNum[i]>0){ //더 큰 우선순위 있음
                    queue.add(now);
                    break;
                }
            }

            if(i>=10) { //실행
                answer++;
                if(now==location)
                    return answer;
                priorNum[priorities[now]]--;
            }
        }
        return answer;
    }
}