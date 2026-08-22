class Solution {
    public void sortColors(int[] nums) {
        int cou0=0,cou1=0,cou2=0;
        int i,n=nums.length;
        for(i=0;i<n;i++)
        {
           if(nums[i]==0)
               cou0++;
            else if(nums[i]==1)
               cou1++;
            else
               cou2++;
        }
        int x=0;
        for(i=0;i<cou0;i++)
            nums[x++]=0;
        for(i=0;i<cou1;i++)
            nums[x++]=1;
        for(i=0;i<cou2;i++)
            nums[x++]=2;
    }
}