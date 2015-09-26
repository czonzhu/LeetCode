public class Solution{
	interface Operator{
		int eval(int x, int y);
	}

	private static final HashMap<String, Operator> map = new HashMap<String, Operator>(){
		{
			put("+", new Operator(){
				public int eval(int x, int y){
					return x + y;
				}
			});
			put("-", new Operator(){
				public int eval(int x, int y){
					return x - y;
				}
			});
			put("*", new Operator(){
				public int eval(int x, int y){
					return x * y;
				}
			});
			put("/", new Operator(){
				public int eval(int x, int y){
					return x / y;
				}
			});
		}
	};

	public int evalRPN(String[] tokens){
		if(tokens == null || tokens.length == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(String str : tokens){
			if(map.containsKey(str)){
				int y = stack.pop();
				int x = stack.pop();
				stack.push(map.get(str).eval(x, y));
			}
			else
				stack.push(Integer.parseInt(str));
		}
		return stack.pop();
	}
}