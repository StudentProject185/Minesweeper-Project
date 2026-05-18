package Part01;

public class Cell {

	private boolean mine;
	private CellState status;
	private int adjacentMines;
	
	public Cell(boolean mine, CellState status, int adjacentMines) {
		this.mine = mine;
		this.status = status;
		this.adjacentMines = adjacentMines;
	}
	
	public Cell() {
		this.mine = false;
		this.status = CellState.HIDDEN;
		this.adjacentMines = 0;
	}

	public boolean isMine() {
		return mine;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	public CellState getStatus() {
		return status;
	}
	public void setStatus(CellState status) {
		this.status = status;
	}
	public int getAdjacentMines() {
		return adjacentMines;
	}
	public void setAdjacentMines(int adjacentMines) {
		this.adjacentMines = adjacentMines;
	}
	
	
	
}
