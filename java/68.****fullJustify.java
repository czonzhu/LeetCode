public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rst = new ArrayList<String>();
        if(words == null || words.length == 0) return rst;
        for(int i = 0, w; i < words.length; i = w){//line by line
            int len = -1, space = 1, extra = 0;
            for(w = i; w < words.length && words[w].length() + len < maxWidth; w++)
                len += words[w].length() + 1;
            StringBuilder sb = new StringBuilder(words[i]);
            if(w != i + 1 && w != words.length){//manage space
                space = (maxWidth - len) / (w - 1 - i) + 1;
                extra = (maxWidth - len) % (w - 1 - i) ;
            }
            for(int k = i + 1; k < w; k++){// record
                for(int l = 0; l < space; l++) sb.append(" ");
                if(extra-- > 0) sb.append(" ");
                sb.append(words[k]);
            }
            int redundance = maxWidth - sb.length();//last line in case that the line does not reach maximum e.g. "" input
            while(redundance-- > 0) sb.append(" ");
            rst.add(sb.toString());
        }
        return rst;
    }
}