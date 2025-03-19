import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int nowDep = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        boolean [][]map = new boolean[n+1][n+1];
        boolean [] chk = new boolean[n+1];
        
        queue.add(new Integer[] {1, 0});
        chk[1] = true;
        
        for(int[] e : edge) {
            map[e[0]][e[1]] = true;
            map[e[1]][e[0]] = true;
        }
        
        while(!queue.isEmpty()){
            Integer[] now = queue.remove(); // 노드 번호, depth
            for(int i=2;i<=n;i++) {
                if(map[now[0]][i] && !chk[i]) {
                    queue.add(new Integer[] {i, now[1]+1});
                    //갯수
                    if(nowDep < now[1] + 1) { //더 멀리 떨어진 노드
                        nowDep = now[1] + 1;
                            answer = 1;
                    }else if(nowDep == now[1] + 1) //현재 가장 멀리 떨어진 노드
                        answer++;
                    chk[i]=true;
                }
            }
        }
        
        return answer;
    }
}

