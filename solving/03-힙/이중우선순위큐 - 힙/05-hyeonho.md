```java
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];

            if (command.equals("D")) {
                if (split[1].equals("1") && !priorityQueue.isEmpty()) {
                    priorityQueue.remove(Collections.max(priorityQueue));
                } else {
                    priorityQueue.poll();
                }
            } else {
                priorityQueue.offer(Integer.valueOf(split[1]));
            }
        }

        System.out.println(priorityQueue);
        if (priorityQueue.size() == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{Collections.max(priorityQueue), priorityQueue.poll()};
        }
    }
```
