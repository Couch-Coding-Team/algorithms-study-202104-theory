```java
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        int tmp = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right) {
            int mid = array[left] + array[right];

            if (mid == 0) {
                answer[0] = array[left];
                answer[1] = array[right];
                break;
            }

            int abs = Math.abs(mid);
            if (abs < tmp) {
                tmp = abs;
                answer[0] = array[left];
                answer[1] = array[right];
            }

            if (mid > 0) {
                right--;
            }
            if (mid < 0) {
                left++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
```
