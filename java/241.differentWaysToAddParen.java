public class Solution{
	private HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	public List<Integer> diffWaysToCompute(String input){
		List<Integer> rst = new ArrayList<Integer>();
		if(input == null || input.length() == 0) return rst;
		if(map.containsKey(input)) return map.get(input);// Use map for optimization.
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == '-' ||
				input.charAt(i) == '+' ||
				input.charAt(i) == '*'){
					String part1 = input.substring(0, i);
					String part2 = input.substring(i + 1);
					List<Integer> part1rst = diffWaysToCompute(part1);
					List<Integer> part2rst = diffWaysToCompute(part2);
					for(int p1 : part1rst){
						for(int p2 : part2rst){
							int c = 0;
							switch(input.charAt(i)){
								case '+': c = p1 + p2;
									break;
								case '-': c = p1 - p2;
									break;
								case '*': c = p1 * p2;
									break;
								default: break;
							}
							rst.add(c);
						}
						
					}
				}
		}
		map.put(input, rst);
		if(rst.size() == 0)
			rst.add(Integer.valueOf(input));
		return rst;
	}
}