import java.util.Arrays
internal object Solution {
  fun solution(numbers:IntArray):String {
    // numbers배열 길이만큼의 String 배열
    val arr = arrayOfNulls<String>(numbers.size)
    for (i in numbers.indices)
    // int -> String

    arr[i] = (numbers[i]).toString()
    Arrays.sort<String>(arr, { o1, o2-> (o2 + o1).compareTo(o1 + o2) })
    if (arr[0] == "0") return "0"
    val sb = StringBuilder()
    for (i in arr.indices)
    sb.append(arr[i])
    return sb.toString()
  }
}
