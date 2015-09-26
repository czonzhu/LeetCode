public class WordDictionary{
	public class TrieNode{
		public TrieNode[] children = new TrieNode[26];
		public String item = "";
	}

	private TrieNode root = new TrieNode();
	public void addWord(String word){
		TrieNode cur = root;
		for(char c : word.toCharArray()){
			if(cur.children[c - 'a'] == null)
				cur.children[c - 'a'] = new TrieNode();
			cur = cur.children[c - 'a'];
		}
		cur.item = word;
	}
    
    public boolean search(String word){
        return match(word.toCharArray(), 0, root);
    }
	private boolean match(char[] chs, int k, TrieNode node){
		if(k == chs.length) return !node.item.equals("");
		if(chs[k] != '.') return node.children[chs[k] - 'a'] != null && match(
		chs, k + 1, node.children[chs[k] - 'a']);
		else{
			for(int i = 0; i < node.children.length; i++){
				if(node.children[i] != null){
					if(match(chs, k + 1, node.children[i]))
						return true;
				}
			}
		}
		return false;
	}
}