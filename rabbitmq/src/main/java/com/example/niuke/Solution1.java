package com.example.niuke;

import java.util.Stack;

/**
 * TODO
 *
 * @author LiuYun
 * @date 2021/5/7 16:25
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(isValid("{}[]"));
    }
    public static boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c =='(') {
                stack.push(')');
            } else if(c =='[') {
                stack.push(']');
            } else if(c =='{') {
                stack.push('}');
            } else if(stack.empty()||stack.pop()!=c) {
                return false;
            }
        }
        return stack.empty();
    }
}
