import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        System.out.println(size);
        
         int[] answer = new int[size];
        
        for(int i=0;i<size;i++){
            int[] cutArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cutArray);
            answer[i] = cutArray[commands[i][2]-1];
        }
        
        return answer;
    }
}