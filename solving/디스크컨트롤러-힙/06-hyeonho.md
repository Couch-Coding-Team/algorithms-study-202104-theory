# 시간 초과, 런타임 에러

## 접근 방식

현재 진행 시간, 각 작업의 **요청 시간**과 **소요시간**을 가지고 문제를 풀려고 하였다.

처음 만든 식은 요청 시간이 현재 진행시간이하의 작업들 중에 가장 빠른 소요시간을 가진 작업을 가져온 뒤

총 소요시간을 answer에 담아 평균을 구한다.

### 총 소요 시간 = 진행 시간 - 작업 요청 시간 + 작업 소요 시간

### 진행 시간 += 작업 소요시간

## 예제

ex)  [[0, 3], [1, 9], [2, 6]]

총 소요 시간  = 0;

진행 시간 = 0;

### **1사이클**

진행 시간이 0이므로 요청 시간이 0 이하인 작업들 중 소요 시간이 빠른 작업을 가져온다. = {0, 3}

총 소요 시간 = 진행 시간(0) - 작업 요청 시간(0) + 작업 소요 시간(3) = **3**

진행 시간 = 작업 소요 시간 = 3

### **2사이클**

진행시간이 3이므로 요청 시간이 3이하인 작업들 중 소요 시간이 빠른 작업을 가져온다. = {2, 6}

총 소요 시간 = 진행 시간(3) - 작업 요청 시간(2) + 작업 소요 시간(6) = **7**

진행 시간 = 3 + 6 = 9;

### 3**사이클**

진행시간이 9이므로 요청 시간이 9이하인 작업들 중 소요 시간이 빠른 작업을 가져온다. = {1, 9}

총 소요 시간 = 진행 시간(9) - 작업 요청 시간(1) + 작업 소요 시간(9) = **17**

진행 시간 = **3** + **7**  + **17** = **26**;

### 정답 = 27 / 3 = 9

코드

```java
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(re);
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;

        Queue<Job> queue = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            Job job = new Job(jobs[i][0], jobs[i][1]);
            list.add(job);
        }

        int totalTime = 0;
        while (true) {

            for (Job job : list) {
                if (job.startAt <= totalTime) {
                    queue.offer(job);
                }
            }
            Job job = queue.poll();
            list.remove(job);

            if (answer == 0) {
                answer += job.time;
            } else {
                answer += totalTime - job.startAt + job.time;
            }

            totalTime += job.time;

            if (list.isEmpty()) {
                break;
            }
        }

        return answer / jobs.length;
    }

}

class Job implements Comparable<Job> {

    int startAt;
    int time;

    public Job(int startAt, int time) {
        this.startAt = startAt;
        this.time = time;
    }

    @Override
    public int compareTo(Job o) {
        return time - o.time;
    }
}
```
