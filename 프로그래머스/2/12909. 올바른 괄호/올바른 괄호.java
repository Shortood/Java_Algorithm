import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i< s.length() ; i++) {
            if(s.charAt(i) == '(') 
                stack.push('(');
            else {
                if(stack.isEmpty() || stack.peek()!='(')
                    return false;
                stack.pop();
            }
            //System.out.println(s.charAt(i));
            
        }
        
        if(!stack.isEmpty())
            answer = false;
        
        return answer;
    }
}