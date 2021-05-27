```java

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        int count = 0;

        int min = -30001;
        for(int[] route : routes) {
            if(min < route[0]) {
                min = route[1];
                count++;
            }
        }
        return count;
    }
```
