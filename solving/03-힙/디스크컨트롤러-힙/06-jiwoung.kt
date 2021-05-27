import java.util.*
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var time = 0
        var waittingQueue = PriorityQueue<Job>(compareBy({ it.start }))

        for (i in 0..jobs.size - 1) {
            var job = Job(jobs[i][0], jobs[i][1])
            waittingQueue.offer(job)
        }
        while (!waittingQueue.isEmpty()) {
            var readyQueue = PriorityQueue<Job>(compareBy { it.during })
            while (!waittingQueue.isEmpty() && time >= waittingQueue.peek().start) {
                readyQueue.offer(waittingQueue.poll())
            }
            if (readyQueue.isEmpty()) {
                time++
                continue
            }
            time += readyQueue.peek().during
            answer += time - readyQueue.peek().start
            readyQueue.poll()

            for (i in 0..readyQueue.size - 1) {
                waittingQueue.offer(readyQueue.poll())
            }
        }
        answer /= jobs.size
        return answer
    }
}

data class
Job(
    var start: Int = 0,
    var during: Int = 0
)
