import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);

        scanner.close();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid1 = findKthElement(nums1, nums2, (total + 1) / 2);
        int mid2 = findKthElement(nums1, nums2, (total + 2) / 2);

        return (mid1 + mid2) / 2.0;
    }

    private int findKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        while (i < m || j < n) {
            if (i >= m) {
                return nums2[j + k - 1];
            }
            if (j >= n) {
                return nums1[i + k - 1];
            }

            int x = nums1[i];
            int y = nums2[j];

            if (k == 1) {
                return Math.min(x, y);
            }

            int p = k / 2;
            int id1 = Math.min(i + p, m) - 1;
            int id2 = Math.min(j + p, n) - 1;

            if (nums1[id1] < nums2[id2]) {
                k -= id1 - i + 1;
                i = id1 + 1;
            } else {
                k -= id2 - j + 1;
                j = id2 + 1;
            }
        }
        return -1;
    }
}
