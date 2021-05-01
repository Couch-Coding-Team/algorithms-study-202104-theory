```python
def solution(jobs):
    ans = 0
    for job in jobs:
        job[1] += job[0]
    jobs.sort(key=lambda x: (x[0],x[1]))
    print(jobs)
    for job in jobs:
        job[1] -= job[0]
    
    elapsed_time = 0
    for job in jobs:
        if (elapsed_time > job[0]):
            print(elapsed_time-job[0] + job[1])
            ans += elapsed_time-job[0] + job[1]
            elapsed_time += job[1]
        else:
            ans += job[1]
            print(job[1])
            elapsed_time = job[1]
    return ans//len(jobs)
```
