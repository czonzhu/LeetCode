public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2; i <= n; i++){
            str = next(str);
        }
        return str;
    }
    public String next(String str){
        int count = 1, i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < str.length()){//while is more flexible with index
            while(i < str.length() - 1 && str.charAt(i + 1) == str.charAt(i)){
                i++;
                count++;
            }
            sb.append(count);//StringBuilder can append integer. pay attention to the use of sb.
            sb.append(str.charAt(i));
            count = 1;
            i++;// Dont forget about this line
        }
        return sb.toString();
    }
}