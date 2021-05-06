class Solution {
      fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);

        return answer
    }

    fun dfs(numbers: IntArray, target: Int, sum: Int, i: Int): Int {
        var count = 0
        if (i == numbers.size) {
if (sum==target){
    return 1
}
            else return 0
        }
        count += dfs(numbers, target, sum + numbers[i], i + 1)
        count += dfs(numbers, target, sum - numbers[i], i + 1)

        return count
    }
}
