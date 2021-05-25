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
	private String headSnake;
	private String tailSnake;
	private String topLadder;
	private String botLadder;
	
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
			currentSymbolPlayers(cPlayer.getnext());
		}
	}
	
	public void addFirstPlayer(Player playerToAdd) {
		if(currentPlayer == null) {
			currentPlayer =  playerToAdd;
			currentPlayer.setnext(currentPlayer);
			currentPlayer.setprev(currentPlayer);
		}else {
			addMorePlayers(currentPlayer, playerToAdd);
		}
	}
	
	private void addMorePlayers(Player current, Player playerToAdd) {
		if(current.getnext()==null) {
			current.setnext(playerToAdd);
			playerToAdd.setprev(current);
		}else {
			addMorePlayers(current, playerToAdd);
		}
	}
	
	public void deleteAPlayer(Player playerToDelete) {
		Player youNeedToGetOut;
		if(currentPlayer == playerToDelete) {	
			currentPlayer = currentPlayer.getnext();
			}if(currentPlayer!=null) {
			youNeedToGetOut = playerToDelete;
			youNeedToGetOut.setnext(null);
		}else if (currentPlayer!=null) {
			deleteAPlayer(currentPlayer.getnext(),playerToDelete);
		}
	}
	
	private void deleteAPlayer(Player actual, Player playerToDelete) {
		if(actual == playerToDelete) {
			Player tempPlayerToRemove = actual;
			Player newNextPlayer = actual.getnext();
			Player newPrevPlayer = actual.getprev();
			newPrevPlayer.setnext(actual.getnext());
			if(newNextPlayer!=null) {
				newNextPlayer.setprev(actual.getprev());
			}
			tempPlayerToRemove.setprev(null);
			tempPlayerToRemove.setnext(null);
		}
		else {
			deleteAPlayer(actual.getnext(),playerToDelete);
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
	
	
	public String getHeadSnake() {
		return headSnake;
	}


	public void setHeadSnake(String headSnake) {
		this.headSnake = headSnake;
	}


	public String getTailSnake() {
		return tailSnake;
	}


	public void setTailSnake(String tailSnake) {
		this.tailSnake = tailSnake;
	}


	public String getTopLadder() {
		return topLadder;
	}


	public void setTopLadder(String topLadder) {
		this.topLadder = topLadder;
	}


	public String getBotLadder() {
		return botLadder;
	}


	public void setBotLadder(String botLadder) {
		this.botLadder = botLadder;
	}


	public String toString() {
		return "["+gridNumber+"]";
	}
}
