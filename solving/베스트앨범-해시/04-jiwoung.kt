import java.util.*
class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()
       
        val map1=HashMap<String,Int>()

         val map=HashMap<String,map1>()
for(i in plays.indices){
    if(map.getOrDefault(genres[i],0)!=0){
        
        map[genres[i]]=map[genres[i]]!!+plays[i]
    }else map[genres[i]]=plays[i]
}
        return answer
    }
}
 class Node(key:String, value:String) {
    var key:String
    var value:String
    init{
      this.key = key
      this.value = value
    }
  }
