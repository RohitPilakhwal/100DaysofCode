class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lb = 0;
        int ub = letters.length - 1;
        int res = 0; // Initialize res to the first index

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;

            if (letters[mid] <= target) {
                lb = mid + 1;
            } else {
                res = mid; // Update res to the current mid if it's a potential answer
                ub = mid - 1;
            }
        }

        // After the loop, lb might be out of bounds, so res will be the smallest               character > target
        // If all characters are <= target, res will point to 0 which is the first              character
        return letters[res % letters.length];
    }

}