class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int last = arr.length - 1;

        while (start < last) {
            int mid = start + (last - start) / 2;

            // Check if mid is the peak
            if (arr[mid] > arr[mid + 1]) {
                // Peak must be on the left half or it is mid itself
                last = mid;
            } else {
                // Peak must be on the right half
                start = mid + 1;
            }
        }

        // When start == last, we have found the peak
        return start;
    }
}