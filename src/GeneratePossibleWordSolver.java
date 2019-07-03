import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneratePossibleWordSolver extends WithDictionary implements BoggleSolver {
	public List<String> solve(Board board) {
		Set<String> words = new HashSet<String>(readDictionary());
		Set<String> foundWords = new HashSet<String>();
		
		for (Node startNode : board.getNodes()) {
			Set<Position> visited = new HashSet<Position>();
			visited.add(startNode.getPosition());
			findAll("" + startNode.getValue(), startNode, board, words, foundWords, visited);
		}
		
		return new ArrayList<String>(foundWords);
	}
	
	private void findAll(String currentWord, Node currentNode, Board board,
					Set<String> words, Set<String> foundWords, Set<Position> visited) {
		if (currentWord.length() > 20) {
			return;
		}
		List<Node> neighbours = new ArrayList<Node>();
		for (Position neighbour : currentNode.getNeighbour()) {
			neighbours.add(positionToNode(neighbour, board));
		}
		for (Node neighbour : neighbours) {
			if (visited.contains(neighbour.getPosition())) {
				continue;
			}
			visited.add(neighbour.getPosition());
			findAll(currentWord + neighbour.getValue(), neighbour, board, words,
					foundWords, visited);
			visited.remove(neighbour.getPosition());
		}
	}

	private Node positionToNode(Position neighbour, Board board) {
		for (Node node : board.getNodes()) {
			if (node.getPosition().equals(neighbour)) {
				return node;
			}
		}
		return null;
	}
}
