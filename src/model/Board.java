package model;

public class Board {
	private int numRows = 0;
	private int numCols = 0;
	Player player;
	Grid firstGrid;
	
	
	public Board(int m, int n) {	
		numRows = m;
		numCols = n;
		firstGrid = new Grid(0,0,1);
		createRow(0,0,firstGrid);
	}
	
	
	
	private void createRow(int i, int j, Grid currentFirstRow) {
		createCol(i,j+1,currentFirstRow,currentFirstRow.getUp());
		if(i+1<numRows) {
			int num = currentFirstRow.getGridNumber();
			Grid downFirstRow = new Grid(i+1,j,num);
			downFirstRow.setUp(currentFirstRow);
			currentFirstRow.setDown(downFirstRow);
			createRow(i+1,j,downFirstRow);
		}
	}

	private void createCol(int i, int j, Grid prev, Grid rowPrev) {
		if(j<numCols) {
			int num = prev.getGridNumber();		
			Grid current = new Grid(i,j,num+1);//n-1
			current.setLeft(prev);
			prev.setRight(current);
			if(rowPrev!=null) {
				rowPrev = rowPrev.getRight();
				current.setUp(rowPrev);
				rowPrev.setDown(current);
			}
			createCol(i,j+1,current,rowPrev);
		}
	}

	public int getNumRows() {
		return numRows;
	}
	public void setNumRows(int m) {
		numRows = m;
	}
	public int getNumCols() {
		return numCols;
	}
	public void setNumCols(int n) {
		numCols = n;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Grid getFirstGrid() {
		return firstGrid;
	}
	public void setFirstGrid(Grid firstGrid) {
		this.firstGrid = firstGrid;
	}
	
	public String toString() {
		String msg;
		msg = toStringRow(firstGrid);
		return msg;
	}

	private String toStringRow(Grid firstRow) {
		String msg = "";
		if(firstRow!=null) {
		msg = toStringCol(firstRow) + "\n";
		msg += toStringRow(firstRow.getDown());
		}
		return msg;
	}

	private String toStringCol(Grid current) {
		String msg = "";
		if(current!=null) {
		msg += current.toString();
		msg += toStringCol(current.getRight());
		}
		return msg;
	}
	
}
