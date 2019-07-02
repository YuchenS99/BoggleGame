import java.util.ArrayList;
import java.util.List;

public class BoggleGame {
	private Board board;
	private BoggleSolver solver;
	
	public BoggleGame(String input) {
		board = buildBoard(input);
		// initialize solver when ready
	}
	
	private Board buildBoard(String input) {
		List<Node> nodes = new ArrayList<Node>(input.length());
		int dimension = (int) Math.sqrt(input.length());
		for (int i = 0; i< input.length(); i++) {
			nodes.add(buildNode(input.charAt(i), 
					  new Position(i / dimension, i % dimension), dimension));
		}
		return new Board(nodes);
	}
	
	private Node buildNode(char value, Position position, int dimension) {
		return new Node(value, position, getNeighbours(position, dimension));
	}
	
	private List<Position> getNeighbours(Position position, int dimension) {
		int[] direction = {-1, 0, 1};
		List<Position> neighbours = new ArrayList<Position>();
		for (int rowDiff : direction) {
			for (int colDiff : direction) {
				Position neighbour = new Position(position.getRow() + rowDiff, 
									position.getColumn() + colDiff);
				if (!position.equals(neighbour) && validPosition(neighbour, dimension)) {
					neighbours.add(neighbour);
				}
			}
		}
		return neighbours;
	}

	private boolean validPosition(Position position, int dimension) {
		return inRange(position.getRow(), dimension) && inRange(position.getColumn(), dimension);
	}
	
	private boolean inRange(int x, int dimension) {
		return x >= 0 && x < dimension;
	}
	
	public void solve() {
		List<String> foundWords = solver.solve(board);
		for (String word : foundWords) {
			System.out.print(word + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		new BoggleGame(args[0]).solve();
	}

}
