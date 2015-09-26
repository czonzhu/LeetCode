public class Solution{
	public boolean isNumber(String s){
	  // 1. blank 2. sign 3. dot 4. exp 5. digit
	  if(s == null || s.length() == 0) return false;
	  int l = 0, r = s.length() - 1;
	  while(l <= r && s.charAt(l) == ' ') l++;
	  if(l >= s.length()) return false;
	  while(l <= r && s.charAt(r) == ' ') r--;

	  if(s.charAt(l) == '+' ||s.charAt(l) == '-') l++;

	  boolean digit = false, dot = false, exp = false;

	  while(l <= r){
	  	if(Character.isDigit(s.charAt(l))) digit = true;
	  	else if(s.charAt(l) == '.'){
	  		if(dot || exp) return false;
	  		dot = true;
	  	}
	  	else if(s.charAt(l) == 'e'){
	  		if(exp || !digit) return false;
	  		exp = true;
	  		digit = false;
	  	}
	  	else if(s.charAt(l) == '+' || s.charAt(l) == '-'){
	  		if(s.charAt(l - 1) != 'e') return false;
	  	}
	  	else return false;
	  	l++;
	  }
	  return digit;
	}
}