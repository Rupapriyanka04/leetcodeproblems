class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(int[] candidates, int target, int index,
                           List<Integer> curr,
                           List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
             backtrack(candidates, target - candidates[i], i, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}