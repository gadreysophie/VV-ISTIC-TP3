package fr.istic.vv;

import java.util.HashMap;
import java.util.Stack;

public class StringUtils {

    private StringUtils() {}
/*
    public static boolean isBalanced(String str) {
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for(int count = 0; count < str.length(); count++) {
            char current = str.charAt(count);

            if(bracketMap.keySet().contains(current)) {
                stack.push(current);
            } else if(bracketMap.values().contains(current)) {
                if(!stack.empty() && bracketMap.get(stack.peek()) == current){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

 */

    public static boolean isBalanced(String str) {
        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < str.length(); a++){
            char let = str.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty())
                    return false;
                switch(let)
                {
                    // Opening square brace
                    case ']':
                        if (S.pop() != '[')
                            return false;
                        break;
                    // Opening curly brace
                    case '}':
                        if (S.pop() != '{')
                            return false;
                        break;
                    // Opening paren brace
                    case ')':
                        if (S.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(S.empty())
            return true;
        return false;
    }

}
