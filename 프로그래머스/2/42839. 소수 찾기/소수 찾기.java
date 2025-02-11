import java.util.*;
import java.io.*;

class Solution {
    boolean[] visit;
    char[] charNumbers;
    int N;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        visit = new boolean[N];
        
        charNumbers = numbers.toCharArray();
        //System.out.println(Arrays.toString(charNumbers));
        dfs("", 0);
        
        System.out.println(set.toString());
        
        int cnt=0;
        for(Integer num:set) {
            if(num>1 && isPrime(num))
                cnt++;
        }
        // while(iter.hasNext()){
        //     if(isPrime(iter.next())){
        //         cnt++;
        //     }
        // }
        return cnt;
    }
    
    public void dfs(String now, int depth) {
        if(depth>=N) return;
        
        for(int i=0;i<N;i++){
            if(visit[i])
                continue;
            visit[i]=true;
            set.add(Integer.parseInt(now + charNumbers[i]));
            dfs(now+charNumbers[i], depth+1);
            visit[i]=false;
        }
    }
    
    public boolean isPrime(int number) {
        for(int i=2;i<=(int)Math.sqrt(number);i++){
            if(number%i==0)
                return false;
        }
        System.out.println(number + "은 소수");
        return true;
    }
}