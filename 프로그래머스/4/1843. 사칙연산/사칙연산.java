class Solution {
    public int solution(String arr[]) {
        int n = arr.length/2 + 1;
        int num[] = new int[n+1];
        String op[] = new String[arr.length - n + 1];
        int dp[][][] = new int[n+1][n+1][2];
        int idx0=1, idx1=1;
        int c1 = 1, c2 = 1;

        for(int i=0;i<arr.length;i++){
            if(i%2==0)
                num[idx0++] = Integer.parseInt(arr[i]);
            else
                op[idx1++] = arr[i];
        }
        
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++){
                if(i==j) {
                    dp[i][j][0] = num[i];
                    dp[i][j][1] = num[i];
                } else{
                    dp[i][j][0] = Integer.MIN_VALUE;
                    dp[i][j][1] = Integer.MAX_VALUE;
                }
            }
        }
        //5개 2길이 1 2 3 4 5  4~5
        for(int len = 2; len<=n;len++) {
            for(int i=1;i<=n-len+1;i++) { //i ~ j
                int j=i+len-1;
                for(int k=i;k<j;k++){
                    if(op[k].equals("+")) {
                        //최대
                        dp[i][j][0] = Math.max(dp[i][j][0], dp[i][k][0] + dp[k+1][j][0]);
                        //최소
                        dp[i][j][1] = Math.min(dp[i][j][1], dp[i][k][1] + dp[k+1][j][1]);
                    } else if(op[k].equals("-")) {
                        //최대
                        dp[i][j][0] = Math.max(dp[i][j][0], dp[i][k][0] - dp[k+1][j][1]);
                        //최소
                        dp[i][j][1] = Math.min(dp[i][j][1], dp[i][k][1] - dp[k+1][j][0]);
                    }
                }
            }
        }
        
        return dp[1][n][0];
    }
}
// 5 3 1 2 4
// 5 3 / 3 1 / 1 2 / 2 4