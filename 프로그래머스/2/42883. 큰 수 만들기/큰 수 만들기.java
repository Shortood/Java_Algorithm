import java.io.*;

class Solution {
    public String solution(String number, int k) { 
        //남겨야 할 수 = 글자수 - k
        //남겨야 할 글자수 앞 에서 가장 큰 수 찾기
        //가장 큰 수 앞 다 날리기
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i = 0; i < number.length() - k; i++) {
            max = 0;
            //System.out.println("index = " + index + " k+i = " + (k+i));
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1; //다음 시작 인덱스
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}