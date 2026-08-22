class Solution {
    public boolean checkDivisibility(int n) {
         int sum=0;
         int o=n,p=1;
         while(n>0) {
            int digit=n%10;
            sum+=digit;
            p*=digit;
            n/=10;
         }
         return o%(sum+p)==0;

    }
}