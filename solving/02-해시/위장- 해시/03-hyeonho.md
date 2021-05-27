```java
import java.util.HashMap;
import java.util.Map;

public class Test {

}

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> dressRoom = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];

            if (dressRoom.containsKey(key)) {
                int quantity = dressRoom.get(key);
                dressRoom.put(key, quantity + 1);
            } else {
                dressRoom.put(key, 1);
            }
        }

        int result = 1;
        for (String key : dressRoom.keySet()) {
            int value = dressRoom.get(key);

            result *= value + 1;
        }

        return result - 1;
    }
}
```