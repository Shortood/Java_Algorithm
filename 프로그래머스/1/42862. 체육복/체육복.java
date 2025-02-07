import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int [n+2];
        int cnt = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int l:lost)
            students[l]--;
        
        for(int r:reserve)
            students[r]++;
        
        for(int i=1;i<=n;i++) {
            if(students[i]<0){ //빌려야 함
                cnt--;
                if(students[i-1]>0){
                    students[i-1]--;
                    students[i]++;
                    cnt++;
                }
                else if(students[i+1]>0){
                    students[i+1]--;
                    students[i]++;
                    cnt++;
                }
            }
        }
        
        
        
        
        return cnt;
    }
}