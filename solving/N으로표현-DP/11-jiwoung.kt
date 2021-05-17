    var k = 0
    var number: Int = 0
    var resultt: Int = 0

    fun fibo(n: Int, depth: Int): Int {
        if (depth >= 8) {
            resultt = (-1)
            return -1
        } else if (n == number) {
            resultt = n
            Log.d("완성",depth.toString())
            return depth
        }

         else {

            fibo(n + k, depth + 1)
            fibo(n - k, depth + 1)
            fibo(n / k, depth + 1)
            fibo(n * k, depth + 1)
            fibo((n*10)+k, depth + 1)
        }
        Log.d("완성123",resultt.toString())
        return depth

    }


    fun solution(N: Int, number: Int): Int {
        var answer = 0
        k=N
        this.number=number
fibo(N,1)

        return answer

    }
