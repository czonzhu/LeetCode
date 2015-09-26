public class Solution{
	//深搜用String 不用 sb 不需要delete
	// 之前path是因为有for 循环，要delete n 次， 这里相当于只有4个循环
	public List<String> findWords(char[][] board, String[] words){
		List<String> rst = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		Trie trie = new Trie();
		for(String word : words){
			trie.insert(word);
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				dfs(rst, "", board, i, j, trie);
			}
		}
		return rst;
	}

	public void dfs(List<String> rst, String str, char[][] board, int i, int j, Trie trie){
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0') return;
	
		str += board[i][j];
		
		if(!trie.startsWith(str)) return;
		if(trie.search(str) && !rst.contains(str)){
			rst.add(str);
		}

		board[i][j] = '0';
		dfs(rst, str, board, i + 1, j, trie);
		dfs(rst, str, board, i - 1, j, trie);
		dfs(rst, str, board, i , j + 1, trie);
		dfs(rst, str, board, i, j - 1, trie);
		board[i][j] = str.charAt(str.length() - 1);
		return;
	}

	class TrieNode{
	// Only 26 children and a String item
	private final TrieNode[] children;
	private String item;

	public TrieNode(){
		children = new TrieNode[26];
		item = "";
	}

	public TrieNode[] getChildren(){
		return children;
	}

	public TrieNode getChild(int i){
		if(i >= 26 || i < 0) throw new IllegalArgumentException();
		return children[i];
	}

	public void setChild(int i, TrieNode node){
		children[i] = node;
		return;
	}

	public void setItem(String item){
		this.item = item;
		return;
	}
	
	public String getItem(){
	    return item;
	}
}


    public class Trie{
    	private TrieNode root;
    
    	public Trie(){
    		root = new TrieNode();
    	}
    
    	public void insert(String word){
    		TrieNode cur = root;
    		for(char c : word.toCharArray()){
    			if(cur.getChild(c - 'a') == null)
    				cur.setChild(c - 'a', new TrieNode());
    			cur = cur.getChild(c - 'a');
    		}
    		cur.setItem(word);
    	}
    
    	public boolean search(String word){
    		TrieNode cur = root;
    		for(char c : word.toCharArray()){
    			if(cur.getChild(c - 'a') == null) return false;
    			cur = cur.getChild(c - 'a');
    		}
    		return cur.getItem().equals(word);
    	}
    
    	public boolean startsWith(String prefix){
    		TrieNode cur = root;
    		for(char c : prefix.toCharArray()){
    			if(cur.getChild(c - 'a') == null) return false;
    			cur = cur.getChild(c - 'a');
    		}
    		return true;
    	}
    }
}