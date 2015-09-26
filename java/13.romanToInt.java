public class Solution {
    public int romanToInt(String s) {
         Map<Character, Integer> map = 
        new HashMap<Character,Integer>(){{
           put('I', 1);  put('V', 5);   put('X', 10);
            put('L', 50); put('C', 100); put('D', 500);
            put('M', 1000);}
        };
        int rst = 0;
        for(int i = 0; i < s.length(); i++){
            rst += map.get(s.charAt(i));
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))
                rst -= 2 * map.get(s.charAt(i - 1));
        }
        return rst;
		
    }
}