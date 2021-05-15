```java
    public String solution2(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int end = k;

        int start = 0;

        for (int i = 0; i < number.length() - k; i++) {
            int tmp = 0;

            for (int j = start; j <= end; j++) {
                if (tmp < number.charAt(j) - '0') {
                    tmp = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            sb.append(tmp);
            end++;
        }

        return sb.toString();
    }
```
