import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1, index = 1;
        int nowWeight = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] {1, truck_weights[0]});
        nowWeight+=truck_weights[0];
        
        while(!queue.isEmpty()){
            time++;
            Integer[] nextTruck = queue.peek();
            if(time - nextTruck[0] >= bridge_length){
                queue.remove();
                nowWeight-=nextTruck[1];
            }
            
            if(index < truck_weights.length &&
               nowWeight + truck_weights[index] <= weight &&
               queue.size() < bridge_length) {
                queue.add(new Integer[] {time, truck_weights[index]});
                nowWeight+=truck_weights[index];
                index++;
            }
        }
        
        return time;
    }
}