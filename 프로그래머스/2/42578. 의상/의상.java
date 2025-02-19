import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String[] c: clothes){
            if(!map.containsKey(c[1])){
                map.put(c[1], 1);
            } else{
                map.put(c[1], map.get(c[1]) + 1);
            }
        }
        
        int[] num = new int[map.size()];
        
        int cnt=0;
        for(Map.Entry<String, Integer> entrySet : map.entrySet()){
            num[cnt] = entrySet.getValue();
            answer+=entrySet.getValue();
            cnt++;
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }
        
        
        answer = dfs(num, 1, 0) - 1;
        
        
        return answer;
    }
    
    public int dfs(int[] num, int total, int depth) {
        if(depth == num.length)
            return total;
        
        return dfs(num, total*num[depth], depth + 1) + dfs(num, total, depth+1);
    }
}