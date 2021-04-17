
```java
import java.util.Arrays;

class Solution {
    public String solution(int[] input) {
        String[] numbers = new String[input.length];

        // int[] -> string[] 타입 변환
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = String.valueOf(input[i]);
        }

        // 비교할 문자열 두 개를 합친 후 두 수를 비교하여 내림차순으로 정렬  ex) 3, 30 -> (330 > 303) -> ["3", "30"]
        Arrays.sort(numbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 정렬된 문자열의 첫번째 인덱스가 0일 경우 0 리턴 ex) 0000 -> 0
        if (numbers[0].equals("0")) {
            return "0";
        }

        // 배열에 담긴 문자열을 문자열로 변환
        StringBuilder result = new StringBuilder()
        for (String sNumber : numbers) {
            result.append(sNumber);
        }

        return result.toString();
    }
}
```
