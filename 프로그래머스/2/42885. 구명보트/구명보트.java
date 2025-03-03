import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        
        Arrays.sort(people);
        int start = 0, end = people.length - 1;
        while(start<end){
            if(people[start] + people[end] <= limit){
                answer--;
                start++;
                end--;
            } else{
                end--;
            }
        }
        return answer;
    }
}