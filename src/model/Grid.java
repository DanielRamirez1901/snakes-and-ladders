package model;

public class Grid {
	private int number;
	private Grid up;
	private Grid down;
	private Grid left;
	private Grid right;
	private int row;
	private int col;
	private int gridNumber;
	
	private String symbolPlayerInGrid;
	private Player currentPlayer;
	
	private boolean isOcupated;
	
	Player player;

	public Grid(int r, int c, int g) {
		row = r;
		col = c;
		gridNumber = g;
		isOcupated = false;
	}
	

	public String getPlayersInGridWithSymbols() {

		symbolPlayerInGrid =  new String();
		currentSymbolPlayers(currentPlayer);
		return symbolPlayerInGrid;
	}
	
	public void currentSymbolPlayers(Player cPlayer) {
		if(cPlayer!=null) {
			symbolPlayerInGrid += cPlayer.getSymbol();
			currentSymbolPlayers(cPlayer.getNextPlayerInGrid());
		}
	}
	
	public void addFirstPlayer(Player playerToAdd) {
		if(currentPlayer == null) {
			currentPlayer =  playerToAdd;
		}else {
			addMorePlayers(currentPlayer, playerToAdd);
		}
	}
	private void addMorePlayers(Player current, Player playerToAdd) {
		if(current.getNextPlayerInGrid()==null) {
			current.setNextPlayerInGrid(playerToAdd);
			playerToAdd.setPrevPlayerInGrid(playerToAdd);
		}else {
			addMorePlayers(current.getNextPlayerInGrid(), playerToAdd);
		}
		
	}


	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public char getNameCol() {
		return (char)('A'+col);
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Grid getUp() {
		return up;
	}

	public void setUp(Grid up) {
		this.up = up;
	}

	public Grid getDown() {
		return down;
	}

	public void setDown(Grid down) {
		this.down = down;
	}

	public Grid getLeft() {
		return left;
	}

	public void setLeft(Grid left) {
		this.left = left;
	}

	public Grid getRight() {
		return right;
	}

	public void setRight(Grid right) {
		this.right = right;
	}

	public boolean isOcupated() {
		return isOcupated;
	}

	public void setOcupated(boolean isOcupated) {
		this.isOcupated = isOcupated;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	
	public int getGridNumber() {
		return gridNumber;
	}

	public void setGridNumber(int gridNumber) {
		this.gridNumber = gridNumber;
	}

	
	public String getSymbolPlayerInGrid() {
		return symbolPlayerInGrid;
	}


	public void setSymbolPlayerInGrid(String symbolPlayerInGrid) {
		this.symbolPlayerInGrid = symbolPlayerInGrid;
	}


	public Player getCurrentPlayer() {
		return currentPlayer;
	}


	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


	public String toString() {
		return "["+gridNumber+"]";
	}
}
