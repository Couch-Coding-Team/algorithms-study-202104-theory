import java.util.*
class Solution {
private lateinit var bool:BooleanArray
    private lateinit var computers: Array<IntArray>
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
bool= BooleanArray(n){false}
        this.computers=computers
        for (i in 0 until n){

            if (!bool[i]){
                answer++
                bfs(i)
            }

        }

        return answer
    }

    fun bfs(i:Int) {

        var queue:Queue<Int> = LinkedList()
bool[i]=true
        queue.offer(i)

        while (queue.isNotEmpty()){
            var poll=queue.poll()
            for (j in computers.indices){

                if (!bool[j]&&poll!=j&&computers[poll][j]==1){
                    
                    queue.offer(j)
bool[j]=true
                }


            }

        }


    }

}
