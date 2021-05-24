class Solution {
        fun solution(n: Int, times: IntArray): Long {
            var answer: Long = 0
            var min:Long = 1
            var max:Long = 0
            for (time in times) {
                max = Math.max(max, time.toLong())
            }
            max *= n
            while (min < max) {
                var mid = (min+max)/2
var m:Long =0
                for (time in times) {
                    m += mid / time
                }
                if (m>=n){
                    max=mid
                }
                 else if (m<n){
                    min=mid+1
                }

            }


            return max
        }
    }
