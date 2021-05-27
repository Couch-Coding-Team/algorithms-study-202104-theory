import java.util.*  
class Solution {
             fun solution(operations: Array<String>): IntArray {
            var answer = intArrayOf(0,0)
            //기본적으로 우선순위큐는 최소힙임
            val maxq = PriorityQueue<Int>(Collections.reverseOrder())
            val minq = PriorityQueue<Int>()

           for (i in operations.indices){
                var list=operations[i].split(" ")

                when(list[0]){
                    "I" -> {
        maxq.offer(list[1].toInt())
            minq.offer(list[1].toInt())

                    }
                    "D"->{
                        if(maxq.isEmpty()) {

                        }
                        //최대
                        else if (list[1].toInt()>0){
            var max=maxq.poll()
                            minq.remove(max)
                        }
                        //최소
                        else{
            var min=minq.poll()
                            maxq.remove(min)
                        }

                    }
                }
                //모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.


            }
            if (!maxq.isEmpty()){
                answer=intArrayOf(maxq.poll(),minq.poll())

            }
            return answer
        }
    }
