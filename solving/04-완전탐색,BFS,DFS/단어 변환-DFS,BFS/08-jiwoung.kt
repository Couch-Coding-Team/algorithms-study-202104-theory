class Solution {
    private lateinit var begin: String
    private lateinit var target: String

    private var answer: Int = 51
    private lateinit var bool : BooleanArray
    var list = ArrayList<Int>()
    fun m(b: String, t: String): Boolean {
        var count = 0
        for (i in b.indices) {
            if (count > 1) {
                break
            }
            if (b[i] != t[i]) {
                count++
            }
        }
        if (count == 1) {
            return true
        }
        return false
    }

    fun solution(begin: String, target: String, words: Array<String>): Int {
        this.answer = answer
        this.begin = begin
        this.target = target
       this.bool= BooleanArray(words.size) { false }


        dfs(0, words,begin)



        return if (answer == 51) 0 else answer
    }

    fun dfs(count: Int, words: Array<String>, first: String) {
        //"hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]

        if (target == first) {
            if (answer>count){
                answer = count
            }
        }

        for (i in words.indices){

            if (!bool[i]&&m(first,words[i])){
            bool[i]=true
                dfs(count+1,words,words[i])
                bool[i]=false

            }

        }


    }
}
