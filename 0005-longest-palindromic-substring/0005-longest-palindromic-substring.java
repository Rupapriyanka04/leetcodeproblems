class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<1 && s==null) 
          return " ";
        int start=0,end=0;
        for(int i=0;i<s.length();i++) {
            int l1=expand(s,i,i);
            int l2=expand(s,i,i+1);
            int len=Math.max(l1,l2);
            if(len>end-start)  {
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expand(String s,int i,int j) {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return j-i-1;
    }
}