import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer="";
        
        for(String parti:participant){
            if(map.containsKey(parti)){ //중복 이름 존재
                int cnt = map.get(parti);
                map.replace(parti, cnt+1); //1명 추가
            }
            else
                map.put(parti, 1);
        }
        
        for(String comple: completion){
            if(map.get(comple)>1) {
                map.replace(comple,map.get(comple)-1);
            }
            else {
                map.remove(comple);
            }
        }
        
        for (String key: map.keySet()) {
            answer=key;
        }

        return answer;
    }
}