import java.util.*;
import java.io.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int N = name.length(), next;
        int move = N -1;
            
        for(int i = 0 ; i < N;i++){
            int n = (int)(name.charAt(i) - 'A');
            if(n>13)
                n=26-n;
            
            //A가 아닌 문자 index
            next = i+1;
            while(next<N && name.charAt(next) == 'A'){
                next++;
            }
            
            move=Math.min(move,Math.min(2*i+(N-next), 2*(N-next)+i));
            
            answer+=n;
        }
   
        return answer + move;
    }
}