# 알고리즘 스터디 문제풀이 (이용훈) 2021-04-17(SAT)

## 2. 기능개발

```python
def solution(progresses, speeds):
    answer = []
    while (progresses):	# progresses를 왼쪽->오른쪽으로 자라나는 stack으로 생각해 주었습니다
        count = 0
        while (progresses[0] < 100):	# stack[top]이 완료될 때까지 모든 진행도는 업데이트 됩니다
            for i in range(len(progresses)):
                progresses[i] += speeds[i]
        while (progresses and progresses[0] >= 100):
            progresses.pop(0)	# 누적된 progresse는 pop합니다
            speeds.pop(0)			# speed는 같이 움직이기 때문에 같이 pop 합니다
            count += 1				# stack의 top부터 완료된 진행도가 있을 때마다 answer에 누적시킵니다
        answer.append(count)
    return answer
```
