        fun solution(genres: Array<String>, plays: IntArray): IntArray {
            var answer = ArrayList<Int>()
            val map = HashMap<String,Int>()// 장르 순위

            for(i in genres.indices){
                map[genres[i]] = map.getOrDefault(genres[i],0)+plays[i]
            }

            //내림차순으로 정렬된 키(장르)를 담는다
            val al = ArrayList<String>(map.keys)
            al.sortWith(Comparator { o1, o2-> (map[o2]!!.compareTo(map[o1]!!)) })

            for(i in 0 until map.size){
                var list=HashMap<String,Int>()

                for(j in genres.indices){


                    if(al[i] == genres[j]){
                        list[j.toString()] = plays[j]
                    }
                }
//포문 두번 쓰기 싫어
                val a2 = ArrayList<String>(list.keys)
                a2.sortWith(Comparator { o1, o2-> (list[o2]!!.compareTo(list[o1]!!)) })
                var result=ArrayList<String>(a2)
                Log.d("알고리즘",  result.toList().toString())
                answer.add(result[0].toInt())
                answer.add(result[1].toInt())

            }

            return answer.toIntArray()
        }
