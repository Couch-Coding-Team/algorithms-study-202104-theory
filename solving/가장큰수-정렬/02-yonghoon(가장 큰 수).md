# 알고리즘 스터디 문제풀이 (이용훈) 2021-04-17(SAT)

## 2. 가장 큰 수

```python
def solution(numbers):
    numbers = list(map(str, numbers))	# map함수를 통해 int->str로 변환한다
    numbers.sort(key = lambda x:x*4, reverse = True)	# python의 문자열 크기비교 특성을 이용함
    answer = ''.join(numbers)
    if (answer[0] == '0'): answer = '0'	# 모두 '0'인 경우엔 예외 처리
    return answer
```
