import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Increase frequency of nums[right]
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // If frequency becomes greater than k,
            // shrink the window from the left
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            // Current window length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}