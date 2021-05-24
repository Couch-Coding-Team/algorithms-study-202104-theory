## 이진탐색

이진 탐색이란 데이터가 정렬돼 있는 배열에서 특정한 값을 찾아내는 알고리즘이다. 배열의 중간에 있는 임의의 값을 선택하여 찾고자 하는 값 X와 비교한다. X가 중간 값보다 작으면 중간 값을 기준으로 좌측의 데이터들을 대상으로, X가 중간값보다 크면 배열의 우측을 대상으로 다시 탐색한다. 동일한 방법으로 다시 중간의 값을 임의로 선택하고 비교한다. 해당 값을 찾을 때까지 이 과정을 반복한다.

![스크린샷 2021-05-24 오후 7 28 26](https://user-images.githubusercontent.com/58363663/119352714-fb4ebb00-bcdc-11eb-9ad0-7bfc5f1d0a42.png)
![스크린샷 2021-05-24 오후 7 30 25](https://user-images.githubusercontent.com/58363663/119352717-fc7fe800-bcdc-11eb-98a0-1b36c5a219e1.png)
![스크린샷 2021-05-24 오후 7 32 58](https://user-images.githubusercontent.com/58363663/119352720-fdb11500-bcdc-11eb-94f1-54e52ac93280.png)

주의할점은 반드시 정렬이 되어있는 상태에서 시작하여야 한다.

자바 코드

```java
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int find = 9;
        binarySearch(array, array.length / 2, find);

    }

    private static void binarySearch(int[] array, int mid, int find) {
        if (find == array[mid]) {
            System.out.println(mid + "번째 인덱스에 있습니다.");
        } else {
            if (find < array[mid]) {
                binarySearch(array, mid / 2, find);
            } else {
                int tmp = (array.length - mid) / 2;
                binarySearch(array, mid + tmp, find);
            }
        }

    }
}
```
