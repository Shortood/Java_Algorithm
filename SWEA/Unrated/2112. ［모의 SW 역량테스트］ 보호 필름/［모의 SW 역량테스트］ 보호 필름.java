import java.util.*;
import java.io.*;

class Solution
{
    static int D, W, K;
    static int answer;
    static int[][] map;
    static int[][] copy;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken()); //두께
            W = Integer.parseInt(st.nextToken()); //가로
            K = Integer.parseInt(st.nextToken()); //기준
            answer = Integer.MAX_VALUE;
            
           // if(K==1) {
              //  System.out.println("#"+test_case + " " + 0);
           //     continue;
            //}
			map = new int[D][W];
            copy = new int[D][W];
            	// 0은 A 1은 B
            
            for(int i=0;i<D;i++){
                 st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                    copy[i][j]=map[i][j];
                }
            }
            if(isPossible()) {
                answer=0;
                System.out.println("#"+test_case + " " + 0);
                continue;
            }
            
            dfs(0, 0);

            System.out.println("#"+test_case + " " + answer);
		}
	}
    
    
    static public void dfs(int depth, int change){ //map, 깊이, 바꾼 줄 수
        if(change >= answer) return;
        if(depth == D) {
            if(isPossible()) {
                 answer = Math.min(answer, change);
            }
               return;
        }
        dfs(depth +1, change);
        
        //현재 depth 전부 A로
        for(int i=0;i<W;i++){
            copy[depth][i]=0;
        }
        dfs(depth +1,change+1);
        
        
        //전부 B로
        for(int i=0;i<W;i++) {
            copy[depth][i]=1;
        }
        dfs(depth +1,change+1);
        
        for(int i=0;i<W;i++){
            copy[depth][i] = map[depth][i];
        }
    }
    
    static public boolean isPossible() { //가능한가
        for(int i=0;i<W;i++){
            int cnt=1;
            int prev = copy[0][i];
            boolean flag = false;
            for(int j=1;j<D;j++){
                if(copy[j][i]==prev)
                    cnt++;
                else
                    cnt=1;
                prev = copy[j][i];
                if(cnt>=K) {
                    flag=true;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        return true;   
    }
}