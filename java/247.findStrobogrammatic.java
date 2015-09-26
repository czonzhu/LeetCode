public class Solution {
	// Recursion: take tree as the inspiration
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    public List<String> helper(int cur, int max){
        if(cur == 0) return new ArrayList<String>(Arrays.asList(""));
        if(cur == 1) return new ArrayList<String>(Arrays.asList("1", "8", "0"));
        
        List<String> rst = new ArrayList<String>();
        List<String> center = helper(cur - 2, max);
        
        for(int i = 0; i < center.size(); i++){
            String tmp = center.get(i);
            if(cur != max) rst.add("0" + tmp + "0");// a number cant be with 0 at either end
            rst.add("1" + tmp + "1");
			rst.add("6" + tmp + "9");
			rst.add("8" + tmp + "8");
			rst.add("9" + tmp + "6");
        }
        return rst;
    }
}