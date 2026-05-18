package Part01;
import java.util.Random;

public class Board {

	Cell[][] grid;

	public int getGridLength() {
		return this.grid.length;
	}

	public Cell getCell(int row, int col) {
		return this.grid[row][col];
	}

	public Board(int n, int m) { 
		//n represents the dimensions of the board
		//m represent the number of mines
		
		if(n <= 0 || m < 0 || m >= n*n) {
			throw new IllegalArgumentException("Arguments are invalid.");
		}
		
		this.grid = new Cell[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = new Cell();
			}
		}
		
		Random r = new Random();
		
		while(m > 0) {
			int d1 = r.nextInt(0, n);
			int d2 = r.nextInt(0, n);
			
			if(!grid[d1][d2].isMine()) {
				grid[d1][d2].setMine(true);
				m--;
			}
		}
		
		this.calculateAdjacentMines();
		
	}
	
	private void calculateAdjacentMines() {
		int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		int n = grid.length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int total = 0;
				
				if(grid[i][j].isMine()) continue;
				
				for(int k = 0; k < 8; k++) {
						int nx = i + dx[k]; 
						int ny = j + dy[k];
						
						if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
							if(grid[nx][ny].isMine()) total++;
					 } 
				 }
				grid[i][j].setAdjacentMines(total);
			}
		}
	}
	
	public void revealCell(int row, int col) {
		int n = grid.length;
		
		if(row < 0 || row >= grid.length || col < 0 || col >= grid.length) return;
		
		Cell start = grid[row][col];
		
		if(start.getStatus() == CellState.FLAGGED) return;
		
		if(start.getStatus() == CellState.REVEALED) return;
		
		start.setStatus(CellState.REVEALED);
		
		if(start.isMine()) return;
		
		if(start.getAdjacentMines() != 0) return;
		
		CoordinateQueue q = new CoordinateQueue();
		q.enqueue(row, col);
		
		int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		while(!q.isEmpty()) {
			
			CoordinateQueue.Coordinate current = q.dequeue();
			
			int x = current.getX();
			int y = current.getY();
			
			for(int k = 0; k < 8; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx >= n || ny >= n || nx < 0 || ny < 0) continue;
				
				Cell neighbor = grid[nx][ny];
				
				if(neighbor.isMine() || (neighbor.getStatus() == CellState.REVEALED) || (neighbor.getStatus() == CellState.FLAGGED)) continue;
				
				neighbor.setStatus(CellState.REVEALED);
				
				if(neighbor.getAdjacentMines() == 0) {
					q.enqueue(nx, ny);
				}
				
			}
			
			
		}
		
	}
	
	
	public GameOutcome getGameState(){
		int n = grid.length;
		
		int cells = 0;
		int revealed = 0;
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(grid[i][j].isMine() && grid[i][j].getStatus() == CellState.REVEALED) {
					return GameOutcome.DEFEAT;
				}
				
				else {
					if(!grid[i][j].isMine()) {
						cells++;
						if(grid[i][j].getStatus() == CellState.REVEALED) revealed++;
						
					}
				}
				
				
			}
		}
		
		if(cells == revealed) return GameOutcome.VICTORY;
		
		return GameOutcome.IN_PROGRESS;
		
	}
	
	

	
}
