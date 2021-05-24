# 이진 탐색

- 정렬된 배열에서 특정 값을 이분법으로 찾는 알고리즘



## 탐색 순서

1. 열의 중간에 있는 임의의 값을 선택하여 찾고자 하는 값 X와 비교
2. X가 중간 값보다 작으면 좌측의 데이터들을 비교, X가 중간값보다 크면 배열의 우측의 데이터들을 비교 
3. 특정 값을 찾을 때까지 반복



## 탐색 방법

- 반복문
- 재귀함수



## 시간복잡도

- O(logN)



## 제곱근 구하기

```java
public static int squareRootLoop(int n) {
    for (int i=0; i<n; i++)
        if (i * i == n)
            return i;
    return -1;
}
//O(N) 
```

```
for (int i=0; i<=n/2; i++)
//O(N) 
```



```
public static int squareRootBSearch(int n) {
    int min = 0;
    int max = n;
    int guess;

    while (min <= max) {
        guess = (min + max) / 2;
        if (guess * guess == n)
            return guess;
        else if (guess * guess > n)
            max = guess - 1;
        else
            min = guess + 1;
    }
    return -1;
}
//O(logN)

//https://cjh5414.github.io/binary-search/
```

