```java

    public int solution(int[] numbers, int target) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> sums = new ArrayList<>();
        queue.offer(0);

        for (int i = 0; i < numbers.length; i++) {
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                sums.add(poll + numbers[i]);
                sums.add(poll - numbers[i]);
            }

            for (int sum : sums) {
                queue.add(sum);
            }

            sums.clear();
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll == target) {
                count++;
            }
        }

        return count;
    }
```
