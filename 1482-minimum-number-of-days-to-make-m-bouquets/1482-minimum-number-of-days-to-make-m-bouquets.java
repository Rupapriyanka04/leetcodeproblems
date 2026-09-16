class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         if((long)m*k>bloomDay.length)
            return -1;
         int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE; 
         for(int i=0;i<bloomDay.length;i++) {
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
         }
         int low=min,high=max;
         while(low<=high) {
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k))
                high=mid-1;
            else
               low=mid+1;
         }
         return low;
    }
    boolean possible(int[] bloomDay,int day,int m,int k) {
        int count=0,noofDays=0;
        for(int i=0;i<bloomDay.length;i++) {
            if(bloomDay[i]<=day)
               count++;
            else {
                noofDays+=(count/k);
                count=0;
            }
        }
        noofDays+=(count/k);
        return noofDays>=m;
    }
}