public class Solution{
	public String fractionToDecimal(int numerator, int denominator){
		if(denominator == 0) return "Wrong Answer";
		if(numerator == 0) return "0";
		StringBuilder rst = new StringBuilder();
		rst.append((numerator > 0) ^ (denominator > 0) ? '-' : "");
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		rst.append(num / den);
		num %= den;
		if(num == 0) return rst.toString();

		rst.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(num, rst.length());
		while(num != 0){
			num *= 10;
			rst.append(num / den);
			num %= den;
			if(map.containsKey(num)){
				rst.insert(map.get(num), "(");
				rst.append(")");
				return rst.toString();
			}
			else map.put(num, rst.length());
		}
		return rst.toString();
	}
}