class Solution { 
    public static int canShip(int[] weights, int capacity) {
        int days=1,load=0;
        for(int i=0;i<weights.length;i++) {
            if(load+weights[i]>capacity) {
                days+=1;
                load=weights[i];
            }
            else
               load+=weights[i];
        }
        return days;
    }
    int shipWithinDays(int[] weights,int days) {
         int low=0,high = 0;

       for(int i = 0; i < weights.length; i++) {
              low = Math.max(low, weights[i]);
              high += weights[i];
        }
        while(low<=high) {
            int mid=(low+high)/2;
            int day=canShip(weights,mid);
            if(day<=days)
              high=mid-1;
            else
              low=mid+1;
        }
        return low;
    }
}