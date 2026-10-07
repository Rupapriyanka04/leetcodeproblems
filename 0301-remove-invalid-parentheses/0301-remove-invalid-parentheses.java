import java.util.*;

class Solution {
    Set<String> result=new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left=0,right=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') left++;
            else if(ch==')'){
                if(left>0) left--;
                else right++;
            }
        }
        backtrack(s,0,left,right,0,new StringBuilder());
        return new ArrayList<>(result);
    }

    void backtrack(String s,int i,int left,int right,int balance,StringBuilder cur){
        if(balance<0) return;
        if(i==s.length()){
            if(left==0&&right==0&&balance==0)
                result.add(cur.toString());
            return;
        }

        char ch=s.charAt(i);

        if(ch=='('){
            if(left>0)
                backtrack(s,i+1,left-1,right,balance,cur);
            cur.append(ch);
            backtrack(s,i+1,left,right,balance+1,cur);
            cur.deleteCharAt(cur.length()-1);
        }
        else if(ch==')'){
            if(right>0)
                backtrack(s,i+1,left,right-1,balance,cur);
            if(balance>0){
                cur.append(ch);
                backtrack(s,i+1,left,right,balance-1,cur);
                cur.deleteCharAt(cur.length()-1);
            }
        }
        else{
            cur.append(ch);
            backtrack(s,i+1,left,right,balance,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}