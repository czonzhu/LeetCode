public class Solution {
    public int compareVersion(String version1, String version2) {
        if((version1 == null || version1.length() == 0) && (version2 == null || version2.length() == 0))return 0;
        if(version1 == null || version1.length() == 0) return -1;
        if(version2 == null || version2.length() == 0) return 1;
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int longest = Math.max(strs1.length, strs2.length);
        for(int i = 0; i < longest; i++){
        	int v1 = i < strs1.length ? Integer.parseInt(strs1[i]) : 0;
        	int v2 = i < strs2.length ? Integer.parseInt(strs2[i]) : 0;
        	if(v1 < v2) return -1;
        	else if(v1 > v2) return 1;
        }
        return 0;
    }
}