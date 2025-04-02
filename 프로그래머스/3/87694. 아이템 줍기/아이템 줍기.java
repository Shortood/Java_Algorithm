import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0 ,0};
        int[] dx2 = {-1, -1, -1, 0, 1, 1, 1, 0}, dy2 = {1, 0, -1, -1, -1, 0, 1, 1};
        int[][] map = new int[101][101];
        boolean[][] chk = new boolean[101][101];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        
        //1인 부분이 테두리
        for(int[] rec : rectangle) {
            for(int i=rec[0]*2 ; i<=rec[2]*2 ; i++){
                for(int j=rec[1]*2 ; j<=rec[3]*2; j++) {
                    if(map[i][j]==2) continue;
                    if(i==rec[0]*2||i==rec[2]*2||j==rec[1]*2||j==rec[3]*2)
                        map[i][j]=1;
                    else
                        map[i][j]=2;
                }
            }
        }
        
        pq.add(new int[] {characterX*2, characterY*2, 0});
        chk[characterX*2][characterY*2] = true;
        
        while(!pq.isEmpty()){
            int[] now = pq.remove();
            //System.out.println("x= " + now[0] + " y = " + now[1] + " c = " + now[2]);
            
            if(now[0]==itemX*2 && now[1]==itemY*2)
                return now[2]/2;
            
            for(int i=0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=1&&ny>=1&&nx<=100&&ny<=100&&!chk[nx][ny]&&map[nx][ny]==1){
                    pq.add(new int[] {nx,ny,now[2]+1});
                    chk[nx][ny]= true;
                }
            }
        }
        
        
        
        return answer;
    }
}