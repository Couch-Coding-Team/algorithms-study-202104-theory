import java.util.*;

import javafx.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int length = people.length;

        Boolean[] booleans=new Boolean[length];
        Arrays.fill(booleans,false);

        for(int i=0;i<length;i++){
            int l=limit;
ArrayList arrayList=new ArrayList<Pair<Integer,Integer>>();
for (int j=i+1;j<length;j++){

    if (((limit-people[i])>=people[j]) &&(booleans[j] != true) ){
        arrayList.add(new Pair(j,people[j]));
    }
}

if (!arrayList.isEmpty()){

    booleans[i]=true;
    arrayList.sort(new Comparator<Pair<Integer, Integer>>() {

        @Override
        public int compare(Pair<Integer, Integer> t1, Pair<Integer, Integer> t2) {
            if (t1.second > t2.second) {
                return 1;
            }   else {
                return -1;
            }
        }

    });

    for (int k =0;i<arrayList.size()-1;k++){
        Pair pair=(Pair)arrayList.get(k);
        int first= (int) pair.first;
        int second= (int) pair.second;
        if (l-second>0){
            l= l-second;
            booleans[first]=true;

        }else{
            answer++;
            break;
        }

    }

}else{


    booleans[i]=true;
    answer++;
}

        }
if (!booleans[length-1]){
    answer++;
}


        return answer;
    }


class Pair<L,R>{
        private L first;
        private R second;
        public Pair(L first,R second){
            this.first=first;
            this.second=second;
        }
        public L first(){return first;}
    public R second(){return second;}


}
}
