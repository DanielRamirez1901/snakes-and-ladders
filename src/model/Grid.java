
package model;

public class Grid {
	private int number;
	private Grid up;
	private Grid down;
	private Grid prev;
	private Grid next;
	private int row;
	private int col;
	private int gridNumber;
	private Grid headSnake;
	private Grid tailSnake;
	private Grid topLadder;
	private Grid botLadder;
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
			currentSymbolPlayers(cPlayer.getNextInGrid());
		}
	}
	
	public void addFirstPlayer(Player playerToAdd) {
		if(currentPlayer == null) {
			currentPlayer =  playerToAdd;
		}else {
			addMorePlayers(currentPlayer.getNextInGrid(), playerToAdd, currentPlayer);
		}
	}
	
	private void addMorePlayers(Player current, Player playerToAdd, Player prevPlayer) {
		if(current == null) {
			current = playerToAdd;
			current.setprev(prevPlayer);
			prevPlayer.setnext(current);
		}else {
			addMorePlayers(current.getNextInGrid(), playerToAdd, current);
		}
	}
	
	public void deleteAPlayer(Player playerToDelete) {
		Player youNeedToGetOut;
		if(currentPlayer == playerToDelete) {	
			currentPlayer = currentPlayer.getNextInGrid();
			if(currentPlayer!=null) {
			youNeedToGetOut = playerToDelete;
			youNeedToGetOut.setNextInGrid(null);
			}
		}else if (currentPlayer!=null) {
			deleteAPlayer(currentPlayer.getNextInGrid(),playerToDelete);
		}
	}
	
	private void deleteAPlayer(Player actual, Player playerToDelete) {
		if(actual == playerToDelete) {
			Player tempPlayerToRemove = actual;
			Player newNextPlayer = actual.getNextInGrid();
			Player newPrevPlayer = actual.getPrevInGrid();
			newPrevPlayer.setnext(actual.getNextInGrid());
			if(newNextPlayer!=null) {
				newNextPlayer.setPrevInGrid(actual.getprev());
			}
			tempPlayerToRemove.setPrevInGrid(null);
			tempPlayerToRemove.setNextInGrid(null);
		}
		else {
			deleteAPlayer(actual.getNextInGrid(),playerToDelete);
		}	
	}

	public boolean gridAreEmpty() {
		return (next == null && down == null && up == null && prev == null);
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

	public Grid getprev() {
		return prev;
	}

	public void setprev(Grid prev) {
		this.prev = prev;
	}

	public Grid getNext() {
		return next;
	}

	public void setNext(Grid next) {
		this.next = next;
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

	public Grid getHeadSnake() {
		return headSnake;
	}


	public void setHeadSnake(Grid headSnake) {
		this.headSnake = headSnake;
	}


	public Grid getTailSnake() {
		return tailSnake;
	}


	public void setTailSnake(Grid tailSnake) {
		this.tailSnake = tailSnake;
	}


	public Grid getTopLadder() {
		return topLadder;
	}


	public void setTopLadder(Grid topLadder) {
		this.topLadder = topLadder;
	}


	public Grid getBotLadder() {
		return botLadder;
	}


	public void setBotLadder(Grid botLadder) {
		this.botLadder = botLadder;
	}


	public String toString() {
		return "["+gridNumber+" " +getPlayersInGridWithSymbols()+"]";
	}
	
	public String toStringWithoutNumber() {
		return "["+getPlayersInGridWithSymbols()+"]";
	}
}

