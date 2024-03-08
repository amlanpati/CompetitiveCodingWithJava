// Valid Parenthesis
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//        Example 1:
//
//        Input: s = "()"
//        Output: true
//        Example 2:
//
//        Input: s = "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: s = "(]"
//        Output: false
//
//
//        Constraints:
//
//        1 <= s.length <= 104
//        s consists of parentheses only '()[]{}'.

import java.util.Stack;

class Solution {
    public boolean isValid(String str) {
        Stack<Character> stck = new Stack<>();
        for (char c: str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stck.push(c);
            }
            else {
                if (stck.isEmpty()) {
                    return false;
                }
                char top = stck.peek();
                if ((c == ')' && top == '(') || ((c == '}') && (top == '{')) || ((c == ']') && (top == '['))) {
                    stck.pop();
                }
                else {
                    return false;
                }
            }    
        }
        return stck.isEmpty();
    }
}
class ValidParenthesis {
    public static void main(String[] args) {
            Solution obj = new Solution();
            System.out.println(obj.isValid("()"));
            System.out.println(obj.isValid("(("));
            System.out.println(obj.isValid("]]"));
            System.out.println(obj.isValid("(]"));
            System.out.println(obj.isValid("}{}"));
            System.out.println(obj.isValid("){"));
            System.out.println(obj.isValid("()[]{}"));
            System.out.println(obj.isValid("())[{]"));
            System.out.println(obj.isValid("({[]})"));
            System.out.println(obj.isValid("[(){}]"));
    }
}