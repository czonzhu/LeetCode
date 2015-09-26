public class Solution{
	public String intToRoman(int num){
		int[] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder rst = new StringBuilder();
		int i = 0;
		while(num != 0 && i < numbers.length){
			if(num - numbers[i] >= 0){
				num -= numbers[i];
				rst.append(symbols[i]);
			}
			else i++;
		}
		return rst.toString();
	}

}