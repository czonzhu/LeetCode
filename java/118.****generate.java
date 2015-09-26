public class Solution{
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();
		for(int i = 1; i <= numRows; i++){
			row.add(0, 1);
			for(int j = 1; j < row.size() - 1; j++){
				row.set(j, row.get(j) + row.get(j + 1));
			}
			rst.add(new ArrayList<Integer>(row));
		}
		return rst;
	}
}