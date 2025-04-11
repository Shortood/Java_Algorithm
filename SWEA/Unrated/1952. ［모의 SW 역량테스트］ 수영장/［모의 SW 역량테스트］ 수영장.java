import java.util.*;
import java.io.*;
// 1일 한달 세달 1년
//모두 1일
//한달씩 + 나머지 1일 -> 모두 한달씩
//다음달, 다다음달 있으면 세달 + 한달 + 1일
//1년
//각 달 1일 치 했을 때 저장
//각 달 1일 치와 한달 비교해서 적은 것 저장
//dp?  dfs?
class Solution
{
    static int ticket1, ticket2, ticket3, ticket4;
    static int[] plan, cost;
    static int answer;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
    	StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            ticket1 = Integer.parseInt(st.nextToken()); //1일
            ticket2 = Integer.parseInt(st.nextToken()); //1달
            ticket3 = Integer.parseInt(st.nextToken()); //3달
            ticket4 = Integer.parseInt(st.nextToken()); //1년
            plan = new int[13];
            cost = new int[13];
            
            st = new StringTokenizer(br.readLine());
            
            for(int i=1;i<=12;i++){
                plan[i] = Integer.parseInt(st.nextToken());
                cost[i] = Math.min(ticket1 * plan[i], ticket2); //더 싼 것 저장
            }
            
            answer = Integer.MAX_VALUE;
            dfs(0, 0);
			System.out.println("#"+test_case+" "+Math.min(answer, ticket4));
		}
	}
    
    static public void dfs(int month, int totalCost) {
         //System.out.println("dfs " + month + " " + totalCost);
        if(month>=12) {
            answer = Math.min(answer, totalCost);
            return;
        }
        //현재 다 더함
        dfs(month + 1, totalCost + cost[month+1]);
        
        if(month <= 9) {
         dfs(month+3, totalCost + ticket3);
        }
    }
}