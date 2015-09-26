public class Solution{
	public String multiply(String num1, String num2){
		// Edge condition to avoid the situation of "0000"
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0 || num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
		int len1 = num1.length(), len2 = num2.length();
		int len = len1 + len2;
		int[] subrst = new int[len];// The length of rst is eighther len1 + len2 - 1 or len1 + len2
		for(int i = 0; i < len1; i++){
			for(int j = 0; j < len2; j++){
				subrst[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');// Here it is +=
			}
		}
		for(int i = len - 1; i > 0; i--){
			subrst[i - 1] += subrst[i] / 10;
			subrst[i] = subrst[i] % 10;
		}
		StringBuilder sb = new StringBuilder();
		if(subrst[0] != 0) sb.append(subrst[0]);//Judge whether the first carry is zero.
		for(int i = 1; i < len; i++){
			sb.append(subrst[i]);
		}
		return sb.toString();
	}
}

/*
	public class Solution {//Interviewbit version test case: with leading zeroes
	public String multiply(String a, String b) {
	    if(a == null || a.length() == 0|| a.equals("0") ||
	        b == null || b.length() == 0 || b.equals("0"))
	        return "0";
	    int len1 = a.length(), len2 = b.length();
	    int len = len1 + len2;
	    int[] rst = new int[len];
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < len1; i++){
	        for(int j = 0; j < len2; j++){
	            rst[i + j + 1] += (a.charAt(i) - '0') * (b.charAt(j) - '0');
	        }
	    }
	    for(int i = len - 1; i > 0; i--){
	        rst[i - 1] += rst[i] / 10;
	        rst[i] %= 10;
	    }
	    int index = 0;
	    while(rst[index] == 0) index++;
	    for(; index < len; index++)
	        sb.append(rst[index]);
	    return sb.toString();
	}
}


*/