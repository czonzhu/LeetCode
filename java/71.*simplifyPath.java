public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        if(path == null || path.length() == 0) return sb.toString();
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String str : strs){
            if(str.equals("..") && !stack.empty())// we cant use ==
                stack.pop();
            else if(!str.equals(".") && !str.equals("") && !str.equals(".."))// easy mistake
                stack.push(str);
        }
        while(!stack.empty()){
            String tmp = stack.pop();
            sb.insert(0, "/" + tmp);
        }
        return sb.length() == 0 ? "/" : sb.toString();// the edge condition "/"
    }
}