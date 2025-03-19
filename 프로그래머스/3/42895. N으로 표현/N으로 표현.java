import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        
        if(N == number)
            return 1;
        
        for(int i=0;i<9;i++)
            dp.add(new HashSet<>());
        
        dp.get(1).add(N);
        
        for(int i=2;i<9;i++){ // i는 현재 N 갯수
            //N i번 반복해서 넣기
            String s = Integer.toString(N);
            dp.get(i).add(Integer.parseInt(s.repeat(i)));
            
            for(int j = 1; j < i ;j++) {
                int k = i - j;
                for(int num1 : dp.get(j)){
                    for(int num2 : dp.get(k)){
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0)
                            dp.get(i).add(num1 / num2);
                    }
                }
            }
            
            if(dp.get(i).contains(number))
                return i;
        }
        
        return -1;
    }
}
// + - * / 숫자붙이기 괄호
// 5

// 5 + 5, 5 - 5, 5 * 5, 5/5, 55

// 55 + 5, 55 - 5, 55 * 5, 55 / 5
// 5 + 55, 5 - 55, 5 / 55, 5 * 55
// (5 + 5) + 5, 

