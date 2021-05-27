class Solution {
         var result = HashSet<Int>()
        fun swap(array: CharArray, a: Int, b: Int) {
            val temp = array[a]
            array[a] = array[b]
            array[b] = temp

        }
        private fun getPrimeCount(numberSet:Set<Int>):Int {
            var result = 0
            for (i in numberSet)
            {
                var isPrime = true
                var j = 2
                while (j * j <= i)
                {
                    if (i % j == 0)
                    {
                        isPrime = false
                        break
                    }
                    j++
                }
                if (isPrime)
                {
                    ++result
                }
            }
            return result
        }
        fun su(numList: CharArray, depth: Int, length: Int) {

            if (depth == length) {
                val sb = StringBuilder()
                for (j in 0 until length) {
                    sb.append(numList[j])
                }
                if (sb.toString().toInt()>1){
                    result.add(sb.toString().toInt())
                }

return
            }

            for (i in depth..numList.size-1) {

                swap(numList, depth, i)
             su(numList, depth+1, length)
                swap(numList, depth, i)
            }

        }

        fun solution(numbers: String): Int {
            var answer = 0

            var depth = 0
            var numList = numbers.toCharArray()

            for (i in 1..numbers.length) {
                su(numList, depth, i)
            }
      answer = getPrimeCount(result)
            Log.d("알고리즘1",result.toList().toString())

            return answer
        }
}
