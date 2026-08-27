class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int l=0,h=n-1;
        int ans=n;
        while(l<=h) {
            int mid=(l+h)/2;
            if(nums[mid]>=target) {
                ans=mid;
                h=mid-1;
            }
            else 
               l=mid+1;
        }
        return ans;
    }
}