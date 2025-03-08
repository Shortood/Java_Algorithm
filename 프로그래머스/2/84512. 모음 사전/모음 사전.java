import java.util.*;
import java.io.*;

class Solution {
    static String[] apWords = new String[] {"A", "E", "I", "O", "U"};
    static int cnt = 0;
    static boolean chk = false;
    
    public int solution(String word) {
        int answer = 0;
        bf("", word);
        
        return cnt;
    }
    
    void bf(String nowWord, String word) {
        if(chk)
            return;

        if(nowWord.equals(word) == true){
            System.out.println("맞음" + cnt);
            chk=true;
            return;
        }
        
        if(nowWord.length() >= 6)
            return;
        
        cnt++;
        
        for(int i=0; i<5;i++){
            bf(nowWord + apWords[i], word);
            if (chk) break;
        }
        
    }
}