class Solution {
     public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] DP=new int[500][500];
        DP[0][0]=triangle[0][0];
        DP[1][0]=triangle[0][0]+triangle[1][0];
        DP[1][1]=triangle[0][0]+triangle[1][1];

        for (int i=2;i<triangle.length;i++){
            for (int j=0;j<triangle[i].length;j++){
                if (j==0){
                    DP[i][j]=DP[i-1][j]+triangle[i][j];
                }
                else if(j==triangle[i].length-1){
                    DP[i][j]=DP[i-1][j-1]+triangle[i][j];
                }
                else{
                    DP[i][j]=triangle[i][j]+Math.max(DP[i-1][j-1],DP[i-1][j]);
                }

            }

        }

      for (int i=0;i<triangle[triangle.length-1].length;i++){
          if (DP[triangle.length-1][i]>answer){
              answer=DP[triangle.length-1][i];
          }
      }

        return answer;
    }

}
