import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


    fun main(args:Array<String>)= with(BufferedReader(InputStreamReader(System.`in`))){
        val (N, C) = readLine().split(' ').map { it.toInt() }
        var array = IntArray(N)
        for (i in 0 until N){
            array[i]=readLine().toInt()
        }

  var min:Long=1

        var max:Long=Integer.MAX_VALUE.toLong() + 1
        var mid:Long=0
        var count:Long=0



        while (min<=max){
            count=0
            mid=((min+max)/2)

            for (i in 0 until N){

                count += array[i]/mid

            }

            if (count>=C){
                min=mid+1
if (mid>max){
    max=mid
}
            }
            else {
                max=mid-1
            }
        }
        println(max)

    }
