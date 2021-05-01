```python
import heapq

def solution(scoville, K):
    answer = 0
    heap = []
    new_element = 0
    for num in scoville:
        if (num < K):
            heapq.heappush(heap, num)
    while (heap):
        if (len(heap) == 1):
            if (heapq.heappop(heap) + new_element * 2 < K):
                return -1
            else:
                answer += 1
                break
        else:
            new_element = heapq.heappop(heap) + heapq.heappop(heap)*2
            answer += 1
            if (new_element < K):
                heapq.heappush(heap, new_element)
                new_element = 0
    return answer
    
```
