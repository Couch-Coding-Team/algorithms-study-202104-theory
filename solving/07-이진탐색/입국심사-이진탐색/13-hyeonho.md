```java
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");

        int t = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        int[] array = new int[t];

        for (int i = 0; i < t; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int answer = 0;

        int left = 1;
        int right = array[array.length - 1] - array[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (install(array, mid, n)) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    private static boolean install(int[] array,int mid, int n) {

        int install = 1;
        int last = array[0] + mid;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= last) {
                install += 1;
                last = array[i] + mid;
            }
        }

        return install >= n;
    }
}

```
