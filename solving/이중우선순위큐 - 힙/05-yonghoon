```python
from collections import deque

def solution(operations):
    pq = deque()
    for operation in operations:
        order = operation.split()[0]
        number = int(operation.split()[1])
        if (order == "I"):
            pq.append(number)
            pq = deque(sorted(pq))
        elif (order == "D" and number == 1):
            if (len(pq) == 0): continue
            pq.pop()
        elif (order == "D" and number == -1):
            if (len(pq) == 0): continue
            pq.popleft()
    if (len(pq) == 0):
        return [0,0]
    else:
        return [pq[len(pq)-1], pq[0]]
```
