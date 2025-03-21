class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int i1 = n / 2;
        int i2 = i1 - 1;

        int count = 0; // index tracker
        int i = 0, j = 0;
        int index1 = -1, index2 = -1;

        // Merge process without extra space
        while (i < n1 && j < n2) {
            int val;
            if (nums1[i] < nums2[j]) {
                val = nums1[i++];
            } else {
                val = nums2[j++];
            }

            if (count == i1) index1 = val;
            if (count == i2) index2 = val;
            count++;
        }

        // If elements remain in nums1
        while (i < n1) {
            if (count == i1) index1 = nums1[i];
            if (count == i2) index2 = nums1[i];
            count++;
            i++;
        }

        // If elements remain in nums2
        while (j < n2) {
            if (count == i1) index1 = nums2[j];
            if (count == i2) index2 = nums2[j];
            count++;
            j++;
        }

        // Return median based on odd/even size
        return (n % 2 == 1) ? index1 : (index1 + index2) / 2.0;
    }
}
