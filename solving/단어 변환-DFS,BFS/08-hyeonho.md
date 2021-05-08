```java
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[words.length];

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.word.equals(target)) {
                answer = node.edge;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visit[i] && isChangeable(node.word, words[i])) {
                    visit[i] = true;

                    queue.add(new Node(words[i], node.edge + 1));
                }
            }
        }

        return answer;
    }

    class Node {
        String word;
        int edge;

        public Node(String word, int edge) {
            this.word = word;
            this.edge = edge;
        }
    }

    private boolean isChangeable(String t, String word) {
        int wantCount = t.length();
        int count = 0;

        char[] x = t.toCharArray();
        char[] y = word.toCharArray();

        for (int i = 0; i < x.length; i++) {
            if (x[i] == y[i]) {
                count++;
            }
        }

        if (wantCount - 1 == count) {
            return true;
        }

        return false;
    }
}


```
