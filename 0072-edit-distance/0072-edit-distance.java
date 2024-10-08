class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                else if(j==0){
                    dp[i][j] = i;
                }
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    // add operation
                    int add_oper = dp[i][j-1] + 1;
                    // delete operation
                    int del_oper = dp[i-1][j] + 1;
                    // replace operation
                    int rep_oper = dp[i-1][j-1] + 1;
                    
                    int temp = Math.min(add_oper,del_oper);
                    dp[i][j] = Math.min(temp,rep_oper);
                    
                }
            }
        }
        return dp[n][m];
    }
}