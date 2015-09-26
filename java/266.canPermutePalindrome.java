public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        Set<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray()){
            if(set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1;
    }
}