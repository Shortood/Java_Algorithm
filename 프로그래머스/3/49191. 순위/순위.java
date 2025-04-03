class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        
        for(int [] result : results) {
            graph[result[0]][result[1]] = 1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(graph[j][i]==1 && graph[i][k]==1){
                        graph[j][k]=1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(graph[i][j]==1 || graph[j][i]==1)
                    cnt++;
            }
            if(cnt==n-1)
                answer++;
        }
        return answer;
    }
}
// n-1번 출전한 선수는 순위 알 수 있음
// 순위를 아는 선수에게 진 선수는 그 뒤 순위
// 이기면 그 앞 순위
