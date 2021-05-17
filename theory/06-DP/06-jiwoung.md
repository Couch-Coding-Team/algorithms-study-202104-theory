# D.P(동적 계획법)

- 큰 문제를 작은 문제로 나누어서 푸는 방식의 알고리즘



## 피보나치 수열

- 제2항까지는 1, 제3항부터는 바로 앞의 두 항을 더한 수로 정의



```
int fibo(int n)
  {
    if (n<=2)
      return 1;
    else
      return fibo(n-1) + fibo(n-2);
   }
```

- 6번째 수열을 구하기 위해  fibo(4)  * 2  , fibo(3) * 3이 중복적으로 계산된다.
- 반복되는 연산에서 나오는 결점을 보완하기 위해 DP가 나옴

## 

## 방식

### 메모이제이션(Memoization)

- 반복적인 부분을 저장시켜두고 같은 부분이 나왔을때 저장돼있던 부분을 꺼내서 사용
- TOP-down : 큰 문제를 작은 문제로 나눠서 푼다 ( 재귀)

```
int d[100];
int fibonacci(int n) {
    if (n <= 1) {
    	return n;
    } else {
        if (d[n] > 0) {	
            return d[n];	
        }
        d[n] = fibonacci(n-1) + fibonacci(n-2);
        return d[n];
    }
}
```



- Bottom-up : 작은 문제부터 푼다 (반복문)

```
int d[100];
int fibonacci(int n) {
    d[0] = 0;
    d[1] = 1;
    for (int i=2; i<=n; i++) {
    	d[i] = d[i-1] + d[i-2];
    }
    return d[n];
}
```

