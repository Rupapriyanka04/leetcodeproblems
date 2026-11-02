class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums.length / 2;
        int median = nums[mid];

        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}