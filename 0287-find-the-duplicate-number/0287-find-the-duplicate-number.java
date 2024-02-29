import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                break;
            }
        }
        return nums[i];
    }
}