import java.util.*;
import java.io.*;

class Solution
{
    static int N, K;
    static int[][] map;
    static boolean[][] chk;
    static int[] dx = {1, -1, 0 ,0}, dy = {0, 0, 1, -1};
  	static int answer;
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
       

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int maxH=0;
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++) {
            	st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                    maxH = Math.max(maxH, map[i][j]);
                }
            }
            
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j] == maxH) { // 봉우리
                        chk = new boolean[N][N];
                        dfs(i, j, false, 1);
                    }
                }
            }
			System.out.println("#" + test_case + " " + answer);
		}
	}
    
    static void dfs(int x, int y, boolean isDelete, int cnt) {
        //System.out.println("x=" + x + " y=" + y + " " + isDelete + cnt);
        int now = map[x][y];
        if(cnt>answer){
            answer = cnt;
              //System.out.println("최대 " + cnt);
        }
        chk[x][y] = true;
        for(int i=0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0&& nx<N && ny<N && !chk[nx][ny]){ // 이동 가능
                if(map[nx][ny] < now) { //이동 가능
                    dfs(nx, ny ,isDelete, cnt + 1);
                } else if(!isDelete && map[nx][ny] - now < K) { //지워서 이동 가능
                    int tmp = map[nx][ny];
                    map[nx][ny] = now - 1;
                    dfs(nx, ny, true, cnt + 1);
                     map[nx][ny] = tmp; //복구
                }
            }
        }
        chk[x][y] = false;
    }
        
}