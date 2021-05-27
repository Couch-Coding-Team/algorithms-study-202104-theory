
    
```python
def solution(prices):
    answer = [0] * len(prices)
    stack = [0]     # index를 담는 stack

    for i in range(len(prices)):    # answer 리스트 초기화
        answer[i] = len(prices)-1-i

    for i in range(1, len(prices)):
        while (stack and prices[i] < prices[stack[-1]]):
            answer[stack[-1]] = i-stack[-1] # 현재 시간 - 기록된 시간
            stack.pop() # stack[-1]의 값이 현재의 값보다 작은 경우에는 pop한다
        stack.append(i)
    return answer
```