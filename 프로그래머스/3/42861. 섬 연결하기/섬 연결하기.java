import java.util.*;

class Solution {
    static int[] parent;
    
    public int find(int n) {
        if(parent[n] == n) 
            return n;
        else 
            return find(parent[n]);
    }
    
    public void union(int num1, int num2){
        num1 = find(num1);
        num2 = find(num2);
        if(num1 != num2)
            parent[num2] = num1;
    }
    
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i=0;i<parent.length;i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int[] cost : costs){
            if(find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer+=cost[2];
            }
        }
        
        return answer;
    }
}