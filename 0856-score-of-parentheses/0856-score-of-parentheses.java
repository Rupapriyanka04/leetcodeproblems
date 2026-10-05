class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(')  
                stack.push(0);
            else {
                
                int inner = stack.pop();
                int score = Math.max(2 * inner, 1); 
                stack.push(stack.pop() + score);
            }
        }
        return stack.peek();
    }
}