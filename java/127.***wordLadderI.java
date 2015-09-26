public class Solution{
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict){
		if(beginWord.equals(endWord)) return 2;
		wordDict.remove(beginWord);
		int len = 1;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);

		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				String cur = queue.poll();
				for(int j = 0; j < cur.length(); j++){
					StringBuilder sb = new StringBuilder(cur);
					for(char c = 'a'; c <='z'; c++){
					    sb.setCharAt(j, c);
						String newstr = sb.toString();
						if(newstr.equals(cur)) continue;
						if(newstr.equals(endWord)) return len + 1;
						if(wordDict.contains(newstr)){
							queue.offer(newstr);
							wordDict.remove(newstr);
						}
					}
				}
			}
			len++;
		}
		return 0;
	}
}