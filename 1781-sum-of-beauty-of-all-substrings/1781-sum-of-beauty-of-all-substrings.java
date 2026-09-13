class Solution {
    public int beautySum(String s) {
       int n=s.length();
       int ans=0;
       for(int i=0;i<n;i++) {
        int[] freq=new int[26];
        for(int j=i;j<n;j++) {
            char ch=s.charAt(j);
            freq[ch-'a']++;
            int maxf=0;
            int minf=Integer.MAX_VALUE;
            for(int k=0;k<26;k++) {
                if(freq[k]>0) {
                    maxf=Math.max(maxf,freq[k]);
                    minf=Math.min(minf,freq[k]);
                }
            }
            ans+=(maxf-minf);
        }
       } 
       return ans;
    }
}