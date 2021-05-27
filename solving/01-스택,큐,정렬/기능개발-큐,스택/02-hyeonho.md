```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();

        // 배포 가능일을 큐에 담는다.
        for (int i = 0; i < progresses.length; i++) {
            int tmp = 100 - progresses[i];

            if (tmp % speeds[i] == 0) {
                days.offer(tmp / speeds[i]);
            } else {
                days.offer(tmp / speeds[i] + 1);
            }
        }

        List<Integer> results = new ArrayList<>();

        int day = days.poll();
        int result = 1;
        while (!days.isEmpty()) {
            if (day >= days.peek()) {
                result += 1;
                days.poll();
            } else {
                results.add(result);
                result = 1;
                day = days.poll();
            }
        }
        results.add(result);

        return results.stream().mapToInt(i -> i).toArray();
    }
}
```
