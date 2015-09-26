public class Solution {
    public boolean isMatch(String s, String p) {
        int ps = 0, pp = 0, match = 0, star = -1;
        while(ps < s.length()){// we cant take pp to the end as an ending condition
            if(pp < p.length() && (s.charAt(ps) == p.charAt(pp) || p.charAt(pp) == '?')){
                ps++;
                pp++;
                continue;
            }
            else if(pp < p.length() && p.charAt(pp) == '*'){// Note the point to start over
                star = pp;
                match = ps;
                pp++;
                continue;
            }
            else if(star != -1){//重来with no way to go let the star devote for more
                pp = star + 1;
                match++;
                ps = match;
                continue;
            }
            return false;
        }
        while(pp < p.length() && p.charAt(pp) == '*') pp++;
        return pp == p.length();
    }
}