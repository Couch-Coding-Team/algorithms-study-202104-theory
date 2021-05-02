```python
    def solution(jobs):
    ans = 0
    def my_sort(job, arr):
        if (job[0] >= arr[0]):
            temp1 = job[1]*2 + arr[1] + job[0]-arr[0]
            temp2 = arr[1]*2 + job[1] - (job[0]-arr[0])
        else:
            temp1 = job[1] * 2 + arr[1] - (arr[0] - job[0])
            temp2 = arr[1]*2 + job[1] + (arr[0]-job[0])
        if (temp1 < temp2):
            return True
        elif (temp1 == temp2 and job[0] < arr[0]):
            return True
        else:
            return False
    for i in range(len(jobs)-1):
        for j in range(len(jobs)-i-1):
            if (my_sort(jobs[j],jobs[j+1])):
                jobs[j], jobs[j+1] = jobs[j+1], jobs[j]
    jobs = jobs[::-1]
    # print(jobs)
    
    end_time = 0
    for job in jobs:
        if (job[0] < end_time):
            complete_time = end_time - job[0] + job[1]
            # print(complete_time, end_time, job[0], job[1])
            ans += complete_time
            end_time = end_time + job[1]
        else:
            complete_time = job[1]
            # print(complete_time)
            ans += complete_time
            end_time = job[0] + job[1]
    return ans // len(jobs)
```
