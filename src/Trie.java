
public class Trie {
	private TrieNode root = new TrieNode();
	
	public void addWord(String word) {
		root.addWord(word.toLowerCase());
	}
	
	public boolean hasPrefix(String word) {
		TrieNode node = descend(word);
		return node != null;
	}
	
	public boolean isWord(String word) {
		TrieNode node = descend(word);
		return node == null ? false : node.isWord();
	}
	
	private TrieNode descend(String word) {
		TrieNode lastNode = root;
		for (int i = 0; i < word.length(); i++) {
			lastNode = lastNode.getNode(word.charAt(i));
			if (lastNode == null) {
				break;
			}
		}
		return lastNode;
	}
}
