public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for(int i = 0;i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Comparator<String> numCom = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(strs, numCom);
        for(int i = strs.length - 1; i >= 0; i--){
            sb.append(strs[i]);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}