class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int size = sizes.length;
        int totalWidth = 0, totalHeight = 0;
        
        for(int i=0;i<size;i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            
            int bigW1 = Math.max(totalWidth, width);
            int bigH1 = Math.max(totalHeight, height);
            
            int bigW2 = Math.max(totalWidth, height);
            int bigH2 = Math.max(totalHeight, width);
            
            if(bigW1 * bigH1 < bigW2 * bigH2){
                totalWidth = bigW1;
                totalHeight = bigH1;
            } else {
                totalWidth = bigW2;
                totalHeight = bigH2;
            }
        }
        
        
        return totalWidth * totalHeight;
    }
}