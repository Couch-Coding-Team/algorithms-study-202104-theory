```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        /**
         * 장르의 이름과 해당 장르의 총 조회수를 가진 Music 클래스를 생성하기 위해
         * HashMap을 사용하여 생성한다.
         */
        Map<String, Integer> musics = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int play = plays[i];

            if (musics.containsKey(name)) {
                int total = musics.get(name);
                musics.put(name, total + play);
            } else {
                musics.put(name, play);
            }
        }

        /**
         * 장르, 총 조회수가 담긴 Hashmap을 사용하여
         * Key: Music, Value: 우선순위 큐 TreeMap을 생성한다.
         * TreeMap을 사용하면 총 조회수가 높은 장르의 음악이 우선적으로 조회가 된다.
         */
        TreeMap<Music, PriorityQueue<UniqueNumber>> musicMap = new TreeMap<>();
        for (String key : musics.keySet()) {
            Music music = new Music(key, musics.get(key));
            musicMap.put(music, new PriorityQueue<>());
        }

        /**
         * UniqueNumber는 고유번호와 해당 고유번호의 조회수를 가지고 생성된다.
         * TreeMap의 value를 우선순위 큐를 사용하였기 때문에
         * value는 조회수가 높은 고유번호가 우선적으로 조회가 된다.
         */
        for (Music music : musicMap.keySet()) {
            for (int index = 0; index < genres.length; index++) {
                String name = genres[index];
                int play = plays[index];

                UniqueNumber uniqueNumber = new UniqueNumber(index, play);

                if (music.name.equals(name)) {
                    PriorityQueue<UniqueNumber> uniqueNumbers = musicMap.get(music);
                    uniqueNumbers.offer(uniqueNumber);
                }
            }
        }

        /**
         * Music 클래스는 각 장르별 총 조회수가 높은 순서대로
         * Unique 클래스는 해당 장르의 조회수가 높은 순서대로 조회된다.
         *
         * 문제가 요구하는 정답은 해당 장르의 조회수가 높은 2개를 가져와야 함으로
         * 2개만 우선순위큐에서 꺼내오면 된다.
         * 1개일 경우 1개만 꺼내도록 한다.
         */
        List<Integer> bestAlbums = new ArrayList<>();
        for (Music music : musicMap.keySet()) {
            PriorityQueue<UniqueNumber> uniqueNumbers = musicMap.get(music);
            if (uniqueNumbers.size() == 1) {
                bestAlbums.add(uniqueNumbers.poll().index);
            } else {
                bestAlbums.add(uniqueNumbers.poll().index);
                bestAlbums.add(uniqueNumbers.poll().index);
            }
        }

        return bestAlbums.stream().mapToInt(integer -> integer).toArray();
    }
}

class Music implements Comparable<Music> {

    String name;

    int total;

    public Music(String name, int total) {
        this.name = name;
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Music)) {
            return false;
        }
        Music music = (Music) o;
        return Objects.equals(name, music.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Music o) {
        return o.total - this.total;
    }
}

class UniqueNumber implements Comparable<UniqueNumber>{
    int index;
    int plays;

    public UniqueNumber(int index, int plays) {
        this.index = index;
        this.plays = plays;
    }

    @Override
    public int compareTo(UniqueNumber o) {
        return o.plays - this.plays;
    }
}
```
