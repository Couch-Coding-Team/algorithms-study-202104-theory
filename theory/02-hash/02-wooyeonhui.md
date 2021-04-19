# Hash
## Hash 함수의 특징
- 어떤 길이의 데이터도 입력으로 사용될 수 있다.
- 결과는 정해진 길이로 나온다.
- SHA256은 입력되는 데이터의 길이와 상관없이 항상 256bits를 결과로 준다.
- 계산 시간이 합리적으로 추정 가능해야한다.
- 입력 길이에 제한이 없기 떄문에 최소한 입력 길이에 선형적으로 비례하는 특성은 있어야한다.
  
## 용어
- 해쉬 : 임의 값을 고정 길이로 변환하는 것
- 해쉬 테이블 : 키 값의 연산에 의해 직접 접근이 가능한 접근이 가능한 데이터 구조
- 해싱 함수 : key에 대해 산술 연산을 이용해 데이터의 위치를 찾을 수 있는 함수
- 해쉬 값 또는 해쉬 주소 : key를 해싱 함수로 연산해서, 해쉬 값을 알아내고, 이를 기반으로 해쉬 테이블에서 해당 key에 대한 데이터 위치를 일관성있게 찾을 수 있음
- 슬롯 : 한 개의 데이터를 저장할 수 있는 공간


## Hash Table
1. 해쉬 구조
   - Hash Table : 키(key)에 데이터(value)를 저장하는 데이터 구조
   - python dictionary 자료 구조

직접 구현해보는 가장 간단한 No답 해쉬 테이블
```
hash_table = list([i for i in range(10)])
print(hash_table)

def hash_func(key):
    return key%5
# 엥?

data1 ='Andy'
data2 = 'Dave'
data3 = 'Trump'

## ord(): 문자의 ASCII 코드 리턴 :: 범위가 작다.
print(ord(data1[0]),ord(data2[0]),ord(data3[0]))

print(ord(data1[0]), hash_func(ord(data1[0])))

def storage_data(data, value):
    key = ord(data[0])
    hash_address = hash_func(key)
    hash_table[hash_address] = value

storage_data('Andy','0101111111')
storage_data('Dave','0102222222')
storage_data('Trump','0103333333')

def get_data(data):
    key = ord(data[0])
    hash_address = hash_func(key)
    return hash_table[hash_address]

print(get_data('Andy'))
print(get_data('Dave'))
print(get_data('Trump'))
```