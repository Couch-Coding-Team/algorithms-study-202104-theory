```python
def solution(people, limit):
    people.sort(reverse = True)
    ans = 0
    for weight in people:
        ans += 1
        if (weight + people[len(people)-1] <= limit):
            people.pop()
    return ans
```
