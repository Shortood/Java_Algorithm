import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int N = maps.length;
        int M = maps[0].length;
        //System.out.println("N = " + N + " M = " + M);
        int[][] move = new int [N][M];
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0, 0, 1});
        
        while(!queue.isEmpty()) {
            int[] now = queue.remove();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //System.out.println("nx = "+ nx + " ny = " + ny);
                if(nx>=0 && ny>=0 && nx<N && ny<M 
                   && (cnt + 1 < move[nx][ny] || move[nx][ny] == 0) 
                   && maps[nx][ny] != 0){
                    queue.add(new int[] {nx, ny, cnt +1});
                    //System.out.println("추가 " + nx +" "+ ny+ " "+ (cnt+1));
                    move[nx][ny] = cnt + 1;
                }
            }
        }
        
        if(move[N-1][M-1] == 0)
            return -1;
        
        return move[N-1][M-1];
    }
}