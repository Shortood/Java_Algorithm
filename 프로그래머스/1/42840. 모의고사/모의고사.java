import java.util.*;

class Solution {
    public Integer[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5},
        second = {2, 1, 2, 3, 2, 4, 2, 5},
        third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int [] sol = {0, 0, 0};
        
        for(int i = 0;i < answers.length;i++){
            if(answers[i]==first[i%5]) sol[0]++;
            if(answers[i]==second[i%8]) sol[1]++;
            if(answers[i]==third[i%10]) sol[2]++;
        }
        
        int max = Math.max(sol[0], sol[1]);
        max = Math.max(max, sol[2]);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<3;i++){
            if(sol[i]>=max) list.add(i+1);
        }
        
        Integer[] answer = list.toArray(new Integer[0]);
        
        return answer;
    }
}