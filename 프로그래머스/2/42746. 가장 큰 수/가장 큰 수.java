import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNumbers = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            stringNumbers[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
            }
        });
        
        StringBuffer sb = new StringBuffer();
        
        for(String string: stringNumbers){
            sb.append(string);
        }
        
        String result = sb.toString();
        //System.out.println(result.length());
       // while(result.charAt(0) =='0' && result.length() > 1) {
       //     result = result.substring(1);
       // }
        if(result.charAt(0) == '0')
            result = "0";
        
        
        
        return result;
    }
}