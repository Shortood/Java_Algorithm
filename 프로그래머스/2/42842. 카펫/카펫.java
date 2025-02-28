import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // 노란 = (가로 - 2) * (세로 - 2)
        // 세로 = 노란/(가로 - 2) + 2
        // 갈색 = 가로 * 2 + (세로 - 2) * 2
        for(int width=3;width<=Math.max(brown, yellow);width++){
            int height = yellow/(width - 2) + 2;
            //System.out.println("width = " + width + " height = " + height);
            if(width * 2 + (height - 2) * 2 == brown && width >= height){
                answer = new int[] {width, height};
                break;
            }
        }
        
        return answer;
    }
}