```python
def solution(name):
    ans = 0
    first_index = 0
    last_index = 0
    temp = ["A"] * len(name)
    can = []
    for i in range(len(name)):
        if (name[i] == "A"): continue
        if (ord(name[i]) - 65 <= 12):
            ans += ord(name[i]) - 65
        else:
            ans += 90 - ord(name[i]) + 1
        temp[i] = ord(name[i])
        
    for i in range(1, len(name)):
        if (name[i] != "A"):
            first_index = i
            break
    for i in range(len(name)-1, 1, -1):
        if (name[i] != "A"):
            last_index = i
            break
    
    # move1) 오른쪽으로만 이동
    move1 = last_index
    can.append(move1)

    # move2) 왼쪽으로만 이동
    move2 = len(name) - first_index
    can.append(move2)
            
            
    # 11_111___________1_1111___11_111_______
    # move3) 오른쪽으로 이동 후 왼쪽으로만 이동
        
    # move4) 왼쪽으로 이동 후 오른쪽으로만 이동
    
    can.sort()
    ans += can[0]

    return ans
```
