```python
import heapq

def solution(scoville, K):
    answer = 0
    heap = []
    new_element = 0
    for num in scoville:
        heapq.heappush(heap, num)
    while (heap):
        if (len(heap) == 1):
            if (heapq.heappop(heap) < K):
                return -1
        elif (heap[0] >= K):
            break
        else:
            new_element = heapq.heappop(heap) + heapq.heappop(heap)*2
            answer += 1
            heapq.heappush(heap, new_element)
    return answer
```
