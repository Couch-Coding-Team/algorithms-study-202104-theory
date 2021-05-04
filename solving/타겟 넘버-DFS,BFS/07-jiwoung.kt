class Solution {

    var result = ArrayList<Int>()
    var ta:Int=0
    fun swap(array: IntArray, a: Int, b: Int) {
        val temp = array[a]
        array[a] = array[b]
        array[b] = temp
    }

    fun su(numList: IntArray, depth: Int, length: Int) {

        if (depth == length) {
            var sb :Int=0
            for (j in 0 until length) {
                numList[j]= (-1*numList[j])
            }
            for (i in 0..numList.size-1){
                sb+=numList[i]
            }
            if (sb.toString().toInt()==ta){
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
