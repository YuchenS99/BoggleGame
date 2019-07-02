import java.util.List;

public class Board {
	
	private final List<Node> nodes;
	
	public Board(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
}
