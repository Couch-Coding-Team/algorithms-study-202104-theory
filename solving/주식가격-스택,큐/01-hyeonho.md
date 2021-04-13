
```java

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * User: yhh1056@naver.com
 * Date: 2021/04/13 Time: 8:49 오후
 *
 * 문제 : 주식가격
 * 주소 : https://programmers.co.kr/learn/courses/30/lessons/42584
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(solution1));

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i] += 1;

                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}

```
