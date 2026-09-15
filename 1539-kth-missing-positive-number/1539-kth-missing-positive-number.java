class Solution {
    public int findKthPositive(int[] vec, int k) {
        int current = 1;
        int i = 0;

        while (k > 0) {
            if (i < vec.length && vec[i] == current) {
                i++;
            } else {
                k--;
                if (k == 0) return current;
            }
            current++;
        }

        return current;
    }
}