public class Solution{
	public int calculate(String s){
		if(s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0, sign = 1, rst = 0;// rst is the prev rst
		for(char c : s.toCharArray()){
			if(Character.isDigit(c)) num = num * 10 + (c - '0');
			else if(c == '+'){
				rst += sign * num;//结算rst 更新num和sign
				num = 0;
				sign = 1;
			} else if(c == '-'){
				rst += sign * num;
				num = 0;
				sign = -1;
			} else if(c == '('){//rst pushed into stack 稍后结算
				stack.push(rst);
				stack.push(sign);
				rst = 0;
				sign = 1;
			} else if(c == ')'){
				rst += sign * num;// 先结算括号内运算片段
				num = 0;
				rst *= stack.pop();//再结算之前未结算的rst
				rst += stack.pop();
			}
		}
		if(num != 0) rst += sign * num;//结算剩余片段
		return rst;
	}
}