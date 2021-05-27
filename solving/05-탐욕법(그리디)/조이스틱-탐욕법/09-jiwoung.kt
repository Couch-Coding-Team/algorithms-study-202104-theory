

// 테스트 케이스 하나 틀림
=> 왔던길을 되돌아 가는게 빠를 경우 

    private lateinit var name: String

    fun solution(name: String): Int {

        var answer = 0
        var list=ArrayList<Char>()
        var list1=ArrayList<Char>()
        var count1=0
        var count2=0
        var result=""
var A=""
        for (i in name.indices){
            A+='A'
            list.add(name[i].toChar())

            list1.add(name[i].toChar())
        }


        list[0]='A'

        for (i in 1 until list.size){

            list[i]='A'
            count1++
            if (list.toList().toString()==A.toList().toString()){

                break
            }
        }

        list1[0]='A'

        for (i in list1.size-1 downTo  1){

            list1[i]='A'
            count2++

            if (list1.toList().toString()==A.toList().toString()){

                break
            }
        }


        val direction= if (count1<=count2) 1 else -1

        if (direction==1){

            for (i in name.indices){
               var a= updown(name[i])
                answer+=a
            }
answer=answer+count1
        }else{

            answer+=updown(name[0])

            for (i in name.length-1 downTo 1){
             answer+=updown(name[i])

            }

      answer=answer+count2

        }

print(answer)
        return answer
    }

fun updown(string: Char):Int{
    var A='A'
    var Z='Z'
    var count1=0
    var count2=0
    if (string=='A'){
        return 0
    }
    while (string!=A){
        A=(A.toInt()+1).toChar()
        count1++
    if (A.toInt() == string.toInt())
        break

    }

    while (string!='A'&&string!=Z){
        count2++
        Z=(Z.toInt()-1).toChar()
        if (Z.toInt() == string.toInt()) {
            break
        }
    }
    return if (count1>=count2) count2+1 else count1
    }

