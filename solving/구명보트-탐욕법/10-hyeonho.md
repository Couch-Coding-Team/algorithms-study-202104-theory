```java
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        for (int person : people) {
            deque.add(person);
        }

        int first;
        int last;

        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                count++;
                break;
            }

            first = deque.peekFirst();
            last = deque.peekLast();

            if (first + last <= limit) {
                count++;
                deque.pollFirst();
                deque.pollLast();
            } else {
                count++;
                deque.pollLast();
            }
        }

        System.out.println(count);
        return count;
    }
```
