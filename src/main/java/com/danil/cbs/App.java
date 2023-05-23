package com.danil.cbs;

import java.util.Stack;

public class App {
    public static void main(String[] args) {
        String bs = "[({})";
        System.out.println(cbs(bs));
    }

    private static boolean cbs(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isOpenBracket(c)) {
                stack.push(c);
            } else {
                char pair = getPairBracket(c);
                if (stack.isEmpty() || stack.pop() != pair) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char c) {
        switch (c) {
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private static char getPairBracket(char c) {
        switch (c) {
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }

}
