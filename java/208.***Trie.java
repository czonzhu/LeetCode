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