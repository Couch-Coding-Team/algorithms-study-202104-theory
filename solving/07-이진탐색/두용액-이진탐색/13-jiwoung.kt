import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val N=readLine().toInt()//전체 용액의 개수

   var liquid=IntArray(N,{0})//전체 용액을 저장할 배열

    val st=StringTokenizer(readLine())

    for(i in 0 until N){
        liquid[i]=st.nextToken().toInt()
    }

    liquid.sort()//오름차순으로 정렬

    var max=2000000000//두 변수의 합을 저장할 변수
    var start=0//시작 포인터
    var end=N-1//끝 포인터

    var start_result=0//sum값이 0에 가장 가까울 때의 시작 포인터 주소를 저장할 변수
    var end_result=0//sum값이 0에 가장 가까울 때의 도착 포인터 주소를 저장할 변수

    while(start < end){
        var sum=liquid[start]+liquid[end]

        if(Math.abs(sum) < max){//만약 sum값이 두 용액의 합친 값의 절대값보다 큰 경우
            //해당 위치의 주소를 저장
            start_result=liquid[start]
            end_result=liquid[end]

            //sum값에 두 용액을 합친 값을 저장
            max=Math.abs(sum)
        }

        //만약 두 용액의 합계가 0 이하인 경우 sum값을 증가시켜야 하므로 시작 포인터를 1 증가
        if(sum <= 0L){
            start++
        }
        //그렇지 않은 경우 sum값을 감소시켜야 하므로 끝 포인터 1 감소
        else{
            end--
        }
    }

    println("$start_result $end_result")

    close()
}
