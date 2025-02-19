class Solution {
    static boolean[] chk;
    static int N, cnt = 0;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        chk = new boolean[N];
        
        dfs(numbers, 0, 0, target);
        
        return cnt;
    }
    
    public void dfs(int[] numbers, int depth, int total, int target) {
        if(depth >= N) {
            if(total == target)
                cnt++;
            return;
        }
        
        dfs(numbers, depth+1, total+numbers[depth], target);
        dfs(numbers, depth+1, total-numbers[depth], target);
    }
}