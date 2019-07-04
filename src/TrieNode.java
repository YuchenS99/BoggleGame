
public class TrieNode {
	private boolean isWord;
	private char character;
	private TrieNode[] children;
	
	protected TrieNode() {
		children = new TrieNode[26];
		isWord = false;
	}
	
	protected TrieNode(char character) {
		this();
		this.character = character;
	}
	
	protected void addWord(String word) {
		int charPos = word.charAt(0) - 'a';
		if (children[charPos] == null) {
			children[charPos] = new TrieNode(word.charAt(0));
		}
		if (word.length() > 1) {
			children[charPos].addWord(word.substring(1));
		} else {
			children[charPos].isWord = true;
		}
	}
	
	protected TrieNode getNode(char c) {
		return children[c - 'a'];
	}
	
	protected boolean isWord() {
		return isWord;
	}
}
