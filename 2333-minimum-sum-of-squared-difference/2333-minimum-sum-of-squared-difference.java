import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long need = 0;

            for (int d : diff) {
                if (d > mid) {
                    need += d - mid;
                }
            }

            if (need <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            diff[i] = Math.min(diff[i], low);
        }

        long used = 0;
        for (int i = 0; i < n; i++) {
            used += Math.abs(nums1[i] - nums2[i]) - diff[i];
        }

        k -= used;
        Arrays.sort(diff);

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (diff[i] > 0) {
                diff[i]--;
                k--;
            }
        }

        long ans = 0;
        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}