class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int mid = total / 2;

        int i = 0;
        int j = 0;

        int prev = 0;
        int curr = 0;

        for (int idx = 0; idx <= mid; idx++) {

            prev = curr;

            if (i < m && j < n) {

                if (nums1[i] <= nums2[j]) {
                    curr = nums1[i];
                    i++;
                } else {
                    curr = nums2[j];
                    j++;
                }

            } else if (i < m) {

                curr = nums1[i];
                i++;

            } else {

                curr = nums2[j];
                j++;
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        }

        return curr;
    }
}