class Solution {
    public int minAddToMakeValid(String s) {
        Deque <Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cr = s.charAt(i);
            if (cr != '(' && cr != ')') {
                continue;
            }
            else if (!stack.isEmpty() && stack.peekLast() == '(' && cr == ')'){
                stack.pollLast();
            }
            else {
                stack.offerLast(cr);
            }
        }
        return stack.size();
    }
}