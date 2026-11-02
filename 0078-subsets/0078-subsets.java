class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    void generate(int[] nums, int index, List<Integer> curr,
                  List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Skip the element
        generate(nums, index + 1, curr, ans);

        // Take the element
        curr.add(nums[index]);
        generate(nums, index + 1, curr, ans);

        // Backtrack
        curr.remove(curr.size() - 1);
    }
}