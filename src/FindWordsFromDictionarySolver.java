import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWordsFromDictionarySolver extends WithDictionary implements BoggleSolver {
	
	public List<String> solve(Board board) {
		List<String> words = readDictionary();
		List<String> foundWords = new ArrayList<String>();
		for (String word : words) {
			if (word.length() > 3 && findWord(word, board)) {
				foundWords.add(word);
			}
		}
		return foundWords;
	}

	private boolean findWord(String word, Board board) {
		List<Node> startingNodes = findStartNode(board, word);
		for (Node startingNode : startingNodes) {
			Set<Position> visited = new HashSet<Position>();
			if (searchForWord(1, word, board, startingNode, visited)) {
				return true;
			}
		}
		return false;
	}

	private boolean searchForWord(int i, String word, Board board, Node startingNode, Set<Position> visited) {
		if (i == word.length()) {
			return true;
		}
		List<Node> neighbours = new ArrayList<Node>();
		for (Position position : startingNode.getNeighbour()) {
			neighbours.add(positionToNode(position, board));
		}
		List<Node> candidates = new ArrayList<Node>();
		for (Node candidate : neighbours) {
			if (visited.contains(candidate.getPosition())) {
				continue;
			}
			if (candidate.getValue() == word.charAt(i)) {
				candidates.add(candidate);
			}
		}
		for (Node node : candidates) {
			visited.add(node.getPosition());
			if (searchForWord(i + 1, word, board, node, visited)){
				return true;
			}
			visited.remove(node.getPosition());
		}
		return false;
	}

	private Node positionToNode(Position position, Board board) {
		for (Node node : board.getNodes()) {
			if (node.getPosition().equals(position)) {
				return node;
			}
		}
		return null;
	}

	private List<Node> findStartNode(Board board, String word) {
		List<Node> startingNodes = new ArrayList<Node>();
		for (Node node : board.getNodes()) {
			if (node.getValue() == word.charAt(0)) {
				startingNodes.add(node);
			}
		}
		return startingNodes;
	}
}
