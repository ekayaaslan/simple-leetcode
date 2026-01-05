// https://leetcode.com/problems/valid-parentheses
// LC20. Valid Parantheses
// Linear time, linear extra-space.
class ValidParantheses {
    class Stack {
        List<Character> list;
        Stack() {
            list = new ArrayList();
        }
        void push(char item) {
            list.add(item);
        }
        char pop() {
            return list.remove(list.size()-1);
        }
        boolean isEmpty() {
            return list.isEmpty();
        }
    }
    boolean isOpen(char a) {
        if (a == '(') { return true; }
        if (a == '{') { return true; }
        if (a == '[') { return true; }
        return false;        
    }        
    boolean isPaired(char a, char b) {
        if (a == '(' && b == ')') { return true; }
        if (a == '{' && b == '}') { return true; }
        if (a == '[' && b == ']') { return true; }
        return false;        
    }    
    public boolean isValid(String s) {
        int n = s.length();
        Stack stack = new Stack();
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if (isOpen(ch)) {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (!isPaired(stack.pop(), ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
