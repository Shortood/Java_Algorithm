import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] reser = new boolean[n+2];
        boolean[] lostStudent = new boolean[n+2];
        
        int answer = 0, cnt = 0;
        Arrays.sort(lost);
        //Arrays.sort(reserve);
        
        for(int l:lost) {// true 이면 잃어버림
            lostStudent[l] = true;
            System.out.println(l + " 번 잃어버림");
        }
        
        for(int r:reserve) { // true 이면 여유분 있음
            reser[r] = true;
            System.out.println(r + " 번 여유");
            if(lostStudent[r]){
                System.out.println("없어짐");
                reser[r]=false;
                lostStudent[r] = false;
            }
        }
        
        
        for(int l:lost) {
            int i;
            if(!lostStudent[l]) continue;
            for(i=l-1;i<=l+1;i++){
                if(reser[i]){
                    reser[i]=false;
                    System.out.println(l + " 번 "+ i + " 번으로 채워짐");
                    break;
                }
            }
            
            if(i>l+1) //여유분 못 찾음
                cnt++;
        }
        return n-cnt;
    }
}