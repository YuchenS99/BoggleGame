public class Position {
	private final int row;
	private final int column;
	
	//post: construct the position 
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	//post: return the row of the position
	public int getRow() {
		return row;
	}
	
	//post: return the column of the position
	public int getColumn() {
		return column;
	}
	
	@Override
	//post: check if two node's position is equal
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof Position) {
			Position objpos = (Position) obj;
			if (objpos.getRow() == this.getRow() && objpos.getColumn() == this.getColumn()) {
				return true;
			}
		}
		return false;
	}
}
