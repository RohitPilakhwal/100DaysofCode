class Solution {
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();
    
        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && ((stack.charAt(stack.length() - 1) == 'A' && c == 'B') || (stack.charAt(stack.length() - 1) == 'C' && c == 'D'))) {
                stack.deleteCharAt(stack.length() - 1); // Remove the last character from the stack (either 'A' or 'C')
            } else {
                stack.append(c); // Add the current character to the stack
            }
        }
    
        return stack.length();
    }
}