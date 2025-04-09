import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken()); // K번째로 큰 수
            char[] numbers = br.readLine().toCharArray();
            HashSet<Long> set = new HashSet<>();
            
            // N 12
            // 012 345 678 91011
            // 123 456 789 10110
            for(int i=0;i<N/4;i++){ // 회전
                int cnt = 0;
                int index = i;
                long sum=0;
                while(cnt<N) {
                    sum=sum*16;
                     if(numbers[index%N]>='A' && numbers[index%N] <= 'F')
                         sum+=((int)numbers[index%N] - 'A' + 10);
                	else
                        sum+=(int)numbers[index%N]-'0';
                       

                    index++;
                    cnt++;
                    if(cnt%(N/4) == 0) { //숫자 한 단위
                        set.add(sum);
                        sum=0;
                    }
                }
            }
            List<Long> lists = new ArrayList<>(set);
			Collections.sort(lists, Collections.reverseOrder());
            
            System.out.println("#"+test_case+" " + lists.get(K-1));
           
		}
	}
}