import java.util.*;
import java.io.*;
    
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int n = set.size();
        System.out.println(n+ "zz");
        if(n<nums.length/2)
            answer=n;
        else
            answer=nums.length/2;
        System.out.println(answer+ " anserr");
        return answer;
    }
}