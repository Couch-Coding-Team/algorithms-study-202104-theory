import java.util.*;
class Solution {
      public int solution(int[] scoville, int K) {
        int answer = 0;

        int first=0;
        int second=0;
        PriorityQueue minq = new PriorityQueue();
        for (int i=0;i<scoville.length;i++){
            minq.offer(scoville[i]);
        }

while ((Integer)minq.peek()<K){
    if (scoville.length-1==answer){
        answer=-1;
        break;
    }

    first= (Integer) minq.poll();
    second= (Integer) minq.poll();
    minq.offer(first+(second*2));
    answer++;
}
        return answer;
    }


}
