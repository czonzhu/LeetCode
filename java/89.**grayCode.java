public class Solution {
    public List<Integer> grayCode(int n){
		List<Integer> rst = new ArrayList<Integer>(Arrays.asList(0));
		for(int i = 1; i < 1 << n; i <<= 1){
			for(int j = rst.size() - 1; j >= 0; j--){
				rst.add(i | rst.get(j));
			}
		}
		return rst;
	}
}