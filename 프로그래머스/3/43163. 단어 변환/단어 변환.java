import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] chk = new boolean[words.length];
        Queue<String> queue = new LinkedList<>();
        
        
        if(!Arrays.asList(words).contains(target))
            return 0;
        
        queue.add(begin);
        while(!queue.isEmpty()) {
            for(int c=0;c<queue.size();c++) {
                String now = queue.remove();
                if(now.equals(target)) return answer;
                for(int i = 0; i< words.length ; i++) {
                    if(!chk[i] && checkTrans(now, words[i])) {
                        //System.out.println("word = " + words[i]);
                        queue.add(words[i]);
                       chk[i]=true;
                    }
                }
            }
            answer++;
            //System.out.println("cnt = " + answer);
        }
        return 0;
    }
    
    public boolean checkTrans(String word1 , String word2){
        int cnt = 0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i) != word2.charAt(i)){
                cnt++;
                if(cnt>1) return false;
            }
        }
        
        return true;
    }
}