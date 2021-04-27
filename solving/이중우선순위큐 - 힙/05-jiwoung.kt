   class Solution {
        private val heapMin:ArrayList<Int>
        private val heapMax:ArrayList<Int>
        init{
            heapMin = ArrayList()
            heapMin.add(0)
            heapMax = ArrayList()
            heapMax.add(0)
        }


        fun solution(operations: Array<String>): IntArray {

            var answer = intArrayOf()


            var insert=operations
            for (i in insert.indices) {
                if (insert[i].toString().contains("|")) {
                    val intStr = insert[i].replace(("[^\\d.]").toRegex(), "")
                    heapMin.add(intStr.toInt())
                } else if (insert[i].toString().contains("D 1")) {
heapMin.sort()
                    heapMin.remove(0)
                } else if (insert[i].toString().contains("D -1")) {
                    heapMin.reverse()
                    heapMin.remove(0)
                }
            }
if (heapMin.isEmpty()){

    return answer=intArrayOf(0,0)
}

            return answer
        }
    }
