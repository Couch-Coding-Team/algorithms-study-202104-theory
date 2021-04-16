import java.util.*

class Solution {
        fun solution(progresses: IntArray, speeds: IntArray): IntArray {
         

            val queue: Queue<Int> = LinkedList()
            var result = mutableListOf<Int>()
            var start=0
            var length=0
            var count=0

            length=progresses.size
            for(i in 0..length-1){

                queue.offer(Math.ceil(((100-progresses[i]).toDouble())/speeds[i].toDouble()).toInt())

            }
            start=queue.poll()
            count++
            
            while(!queue.isEmpty()){
                var next=queue.poll()
                if(start>=next){
                    count++

                }else{
                    result.add(count)
                    start=next
                    count=1
                }

            }
            result.add(count)
               val answer = IntArray(result.size)
            for(i in 0..result.size-1){
                answer[i]=result[i]
                
            }
        
            return answer
        }}
