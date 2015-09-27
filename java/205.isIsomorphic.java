public class Solution{
	// Both of the cur character has never turned up or the position of its last occurence are the same
	public boolean isIsomorphic(String s, String t){
		int[] m1 = new int[256], m2 = new int[256];
		for(int i = 0; i < s.length(); i++){
			if(m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;// The last occurrence should be at the same index
		}
		return true;
	}
}