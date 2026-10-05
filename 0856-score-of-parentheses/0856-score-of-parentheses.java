
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Start a new level
                stack.push(0);
            } else {
                // Get score inside current parentheses
                int inner = stack.pop();

                // () = 1
                // (A) = 2 * A
                int score = Math.max(2 * inner, 1);

                // Add score to previous level
                stack.push(stack.pop() + score);
            }
        }

        return stack.peek();
    }
}