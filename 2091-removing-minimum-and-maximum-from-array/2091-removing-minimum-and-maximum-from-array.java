class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length,min=0,max=0;
        for(int i=1;i<n;i++) {
            if(nums[i]<nums[min]) min=i;
            if(nums[i]>nums[max]) max=i;
        }
        int l=Math.min(min,max),r=Math.max(min,max);
        return Math.min(r+1,
            Math.min(n-l,l+1+n-r)
        );
    }
}