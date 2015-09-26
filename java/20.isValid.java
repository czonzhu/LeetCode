public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
           put('(', ')');
           put('[', ']');
           put('{', '}');
        }};
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){// have to use toCharArray to use c : ...
            if(map.containsKey(c)) stack.push(c);
            else{
                if(stack.empty()) return false;// Dont forget this line
                if(map.get(stack.peek()) == c) stack.pop();
                else return false;
            }
        }
        return stack.empty();
        
    }
}