class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find the starting position of the target
        result[0] = findStart(nums, target);
        if (result[0] == -1) {
            return result; // Target not found
        }
        
        // Find the ending position of the target
        result[1] = findEnd(nums, target);
        return result;
    }
    
    private int findStart(int[] nums, int target) {
        int lb = 0;
        int ub = nums.length - 1;
        int start = -1;
        
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            
            if (nums[mid] == target) {
                start = mid;
                ub = mid - 1; // Continue searching in the left half
            } else if (nums[mid] < target) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        
        return start;
    }
    
    private int findEnd(int[] nums, int target) {
        int lb = 0;
        int ub = nums.length - 1;
        int end = -1;
        
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            
            if (nums[mid] == target) {
                end = mid;
                lb = mid + 1; // Continue searching in the right half
            } else if (nums[mid] < target) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        
        return end;
    }
}