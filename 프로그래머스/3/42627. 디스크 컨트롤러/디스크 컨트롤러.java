import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Process> pq = new PriorityQueue<>(
            new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    if(o1.requiredTime == o2.requiredTime) {
                        if(o1.requestTime == o2.requestTime) {
                             return o1.number - o2.number;
                        }
                        return o1.requestTime - o2.requestTime;   
                    }
                    return o1.requiredTime - o2.requiredTime;
                }
            }
        );
        int answer = 0;
        int index=0;
        int complete = 0;
        int time=0;
        
        while(complete < jobs.length) {
            //현재 시간까지 요청한 작업 다 넣기
            while(index < jobs.length && jobs[index][0] <= time){
                Process process = new Process(index, jobs[index][0], jobs[index][1]);
                pq.add(process);
                index++;
            }
            if(pq.isEmpty())
                time = jobs[index][0];
            
            //우선순위 높은거 하나 완료하기
            if(!pq.isEmpty()) {
                Process nowProcess = pq.remove();
                complete++;
                    
            
                time+= nowProcess.requiredTime;
            
                answer+=time - nowProcess.requestTime;
            }
        }

        return answer/jobs.length;
    }
}

class Process {
    int number;
    int requestTime;
    int requiredTime;
    
    public Process(int number, int requestTime, int requiredTime){
        this.number = number;
        this.requestTime = requestTime;
        this.requiredTime = requiredTime;
    }
    
}