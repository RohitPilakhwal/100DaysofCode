class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        HashSet <Integer> set = new HashSet<>();
        for(int i=0;i<l;i++){
            set.add(nums[i]);
        }
        
        int[] arr = new int[set.size()];
        int i = 0;
        for(int num : set){
            arr[i] = num;
            i++;
        }
        Arrays.sort(arr);
        return lcs(nums,arr,l,arr.length);
    }
    
    public static int lcs(int[] arr1, int[] arr2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<m;j++){
            dp[0][j] = 0;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}