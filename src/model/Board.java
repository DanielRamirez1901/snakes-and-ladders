
package model;

import java.util.Random;

public class Board {
	private int numRows = 0;
	private int numCols = 0;
	Player player;
	Grid firstGrid;
	Player firstPlayer;
	private Player playerWinner;
	private String creationParameters;
	private Score root;
	private String gameInitiationParameters;
	


	public Board() {
		firstGrid = new Grid(0,0,1);
	}

	public void createMatrix(int m, int n) {	
		numRows = m;
		numCols = n;
		createRow(0, 0, firstGrid);
	}
	
	private void createRow(int i, int j, Grid currentFirstRow) {
		createCol(i,j+1,currentFirstRow,currentFirstRow.getUp());
		if(i+1<numRows) {
			int num = ((currentFirstRow.getRow()+1)%2!=0) ? ((currentFirstRow.getRow()+2)*numCols):(((currentFirstRow.getRow()+1)*numCols)+1);
			Grid downFirstRow = new Grid(i+1,j,num);
			downFirstRow.setUp(currentFirstRow);
			currentFirstRow.setDown(downFirstRow);
			createRow(i+1,j,downFirstRow);
		}
	}

	private void createCol(int i, int j, Grid prev, Grid rowPrev) {
		if(j<numCols) {
			int num = ((prev.getRow()+1)%2==0) ? (prev.getGridNumber()-1): (prev.getGridNumber()+1);
			Grid current = new Grid(i,j,num);//n-1
			current.setprev(prev);
			prev.setNext(current);
			if(rowPrev!=null) {
				rowPrev = rowPrev.getNext();
				current.setUp(rowPrev);
				rowPrev.setDown(current);
			}
			createCol(i,j+1,current,rowPrev);
		}
	}
	
	public void movePlayerToNext(Player player,int steps) {
		if(steps>0) {
			firstGrid.setNext(firstGrid);
			if(firstGrid.getNext()!=null) {
				if(firstGrid.getRow()%2!=0) {
					Player temporal = player;
					Grid gridWithPlayer = firstGrid;
					firstGrid.addFirstPlayer(player);
					gridWithPlayer.setNext(firstGrid);
					firstGrid.deleteAPlayer(temporal);
					movePlayerToNext(player,steps-1);
					//firstGrid.moveInSnake
					//firstGrid.moveInLadder
					//firstGrid.movePlayerInPrev
				}
			}
		}else if(firstGrid.getNext()==null) {
				firstGrid.setDown(firstGrid);
				Player temporal = player;
				firstGrid.addFirstPlayer(player);
				if(firstGrid.getRow()%2==0) {
					Grid temporalGrid =  firstGrid;
					firstGrid.setUp(temporalGrid);
					temporalGrid.deleteAPlayer(temporal);
					movePlayerToPrev(player, steps);
				}
			}
		}
	
	
	public void movePlayerToPrev(Player player, int steps) {
		if(steps>0) {
			firstGrid.setprev(firstGrid);
			if(firstGrid.getprev()!=null) {
				if(firstGrid.getRow()%2==0) {
					Player temporal = player;
					Grid gridWithPlayer = firstGrid;
					firstGrid.addFirstPlayer(player);
					gridWithPlayer.setprev(firstGrid);
					firstGrid.deleteAPlayer(temporal);
					//firstGrid.moveInSnake
					//firstGrid.moveInLadderelse 
					movePlayerToPrev(player,steps-1);
				
					//firstGrid.movePlayerInPrev
				}
			}
		}else if(firstGrid.getNext()==null) {
				firstGrid.setDown(firstGrid);
				firstGrid.addFirstPlayer(player);
				Player temporal = player;
				if(firstGrid.getRow()%2!=0) {
					Grid temporalGrid = firstGrid;
					firstGrid.setUp(temporalGrid);
					temporalGrid.deleteAPlayer(temporal);
					movePlayerToNext(player, steps);
				}
			}
		}
	
	public String rollingTheDice() {
		String msgWithInfo =  "";
		int generateSteps=(int)(Math.random()*6+1);
		msgWithInfo = "El jugador "+firstPlayer.getSymbol() + " acaba de lanzar el dado y su puntaje fue de: "+generateSteps;
			if((firstPlayer.getNumberOfPosition()+generateSteps)<=(numCols*numRows)) {
				movePlayer(firstPlayer.getSymbol(), generateSteps);
				firstPlayer.setMovementsOfPlayer(firstPlayer.getNumberOfPosition()+generateSteps);
			}else {
				msgWithInfo += "\n Es imposible para el jugador moverse debido a que necesita un puntaje"
						+ "mejor o igual a: "+((numCols*numRows)-firstPlayer.getMovementsOfPlayer());
			}
			firstPlayer.getnext();
			return msgWithInfo;
	}
	
	public void movePlayer(String symbol, int steps) {
		Player playerToMove = searchSymbolPlayer(symbol, firstPlayer);
		movePlayerToNext(playerToMove, steps);
		checkPlayerPosition(playerToMove);
	}
	
	private Player searchSymbolPlayer(String symbol, Player currentPlayerToSearch) {
		if(currentPlayerToSearch.getSymbol().equalsIgnoreCase(symbol)) {
			return currentPlayerToSearch;//You Fount that player
		}else {
			return searchSymbolPlayer(symbol, currentPlayerToSearch.getnext());//You need to search more
		}
	}

	public void checkPlayerPosition(Player playerToCheck) {
		if(playerToCheck.getPositionInGrid().getGridNumber()==(numCols*numRows)) {
			playerWinner = playerToCheck;
			addPlayerScore(playerWinner.getNickname());
//		}else if(playerToCheck.getPositionInGrid().getHeadSnake()!=null) {
//			playerIsInHead(playerToCheck);
//		}else if(playerToCheck.getPositionInGrid().getBotLadder()!=null) {
//			playerIsInBot(playerToCheck);
//		}
			}
	}
	
	public boolean playerIsInHead(Player current) {
		boolean playerIsInHeadSnake = false;
		if(current!=null) {
			Grid actualGrid = current.getPositionInGrid();
			current.setPositionInGrid(actualGrid.getHeadSnake());
			current.getPositionInGrid().addFirstPlayer(current);
			playerIsInHeadSnake=true;
			movePlayerToTail(current);
			actualGrid.deleteAPlayer(current);
		}
		return playerIsInHeadSnake;
	}

	private void movePlayerToTail(Player playerInHead) {
		if(playerIsInHead(playerInHead)!=false) {
			Grid actualTailGrid = playerInHead.getPositionInGrid();
			playerInHead.setPositionInGrid(actualTailGrid.getTailSnake());
			playerInHead.getPositionInGrid().addFirstPlayer(playerInHead);
			//			Grid deletePlayerInHead = playerInHead.getPositionInGrid();
			//			playerInHead.setPositionInGrid(deletePlayerInHead.getHeadSnake());
			//			deletePlayerInHead.deleteAPlayer(playerInHead);
			//			No se si implementar esta manera de borrar o la anterior
		}
	}

	public boolean playerIsInBot(Player current) {
		boolean playerIsInBot = false;
		if(current!=null) {
		Grid actualBotGrid = current.getPositionInGrid();
		current.setPositionInGrid(actualBotGrid.getBotLadder());
		current.getPositionInGrid().addFirstPlayer(current);
		playerIsInBot=true;
		movePlayerToTop(current);
		actualBotGrid.deleteAPlayer(current);
		}
		return playerIsInBot;
	}
	
	public void movePlayerToTop(Player playerInBot) {
		if(playerIsInBot(playerInBot)!=false) {
		Grid actualTopGrid = playerInBot.getPositionInGrid();
		playerInBot.setPositionInGrid(actualTopGrid.getTopLadder());
		playerInBot.getPositionInGrid().addFirstPlayer(playerInBot);
		}
	}
	
	//mover hacia la parte de arriba de escalera
	
	public void addPlayerInBoard(String symbol, int numOfPlayers) {
		if(numOfPlayers<symbol.length()) {
			int indexOfPosition = numOfPlayers;
			addOnePlayer(String.valueOf(symbol.charAt(indexOfPosition)));
			indexOfPosition++;
			addPlayerInBoard(symbol, indexOfPosition);
		}
	}
	
	public void addOnePlayer(String symbol) {
		if(firstPlayer == null) {
			firstPlayer = new Player(symbol,firstGrid);
			firstPlayer.setnext(firstPlayer);
			firstPlayer.setprev(firstPlayer);
			firstGrid.addFirstPlayer(firstPlayer);
		}else {
			 Player playerToAdd = new Player(symbol, firstGrid);
			 firstPlayer.getprev().setnext(playerToAdd);
			 playerToAdd.setprev(firstPlayer.getprev());
			 firstPlayer.setprev(playerToAdd);
			 playerToAdd.setnext(firstPlayer);
			 firstGrid.addFirstPlayer(playerToAdd);
		}
	}
	
	
	
	public String showWinnerInformation() {
		 String winnerInfo;
	        
	        winnerInfo= "-------------------------------------------";
	        winnerInfo+= "\n**************WINNER**************";
	        winnerInfo+= "\nEl jugador "+playerWinner.getSymbol()+ " ha ganado el juego con " + playerWinner.getMovementsOfPlayer()+" movimientos";
	        winnerInfo+= "\n-------------------------------------------";
	        return winnerInfo;
	}
	
	public void createGameWithPlayersSymbol(int rows, int columns, int snakes, int 	ladders, String symbol) {
		String initiationParameters = rows + " " + columns + " " + snakes + " " + ladders + " " + symbol;
		setCreationParameters(initiationParameters);
		createMatrix(rows, columns);
//		createHeadSnake(snakes);
		//generateLadders(ladders);
		addPlayerInBoard(symbol, 0 );
	}
	
	public void createGameWithAmountPlayers(int rows, int columns, int snakes, int ladders, int amountPlayers) {
		String symbolsOfPlayers = "*!OX%$#+&";
		String creationPlayersWithSymbol = symbolsOfPlayers.substring(0,amountPlayers);
		String initiationParameters = rows + " " + columns + " " + snakes + " " + ladders + " " + amountPlayers;
		setCreationParameters(initiationParameters);
		createMatrix(rows, columns);
//		createHeadSnake(snakes);
		//generateLadders(ladders);
		addPlayerInBoard(creationPlayersWithSymbol, 0 );
	} 

	
	public void createHeadSnake(int numberOfSnakes) {
		if(numberOfSnakes<0) {
		Random randomSymbol = new Random();
		char symbol = (char)(randomSymbol.nextInt(26) + 'A');
		String chartToString = String.valueOf(symbol);
		int headPositionInRow = (int) Math.floor(Math.random()*(1-numRows+1)+numRows);
		int headPositionInCol = (int) Math.floor(Math.random()*(2-numCols+1)+numCols);
		int numberInGrid =  generateRandomPosition(1);
			if(numberOfSnakes<(numCols*numRows)) {
				Grid headSnake = new Grid(headPositionInRow,headPositionInCol,numberInGrid);
				headSnake.setSymbolPlayerInGrid(chartToString);
			}
		}else {
			createHeadSnake(numberOfSnakes-1);
		}
	}
	
	public int generateRandomPosition(int numberOfPosition) {
		numberOfPosition = (int) Math.floor(Math.random()*(1-(numCols*numRows)+1)+(numCols*numRows));
		if(numberOfPosition!=getFirstGrid().getGridNumber()) {
			if(numberOfPosition>numCols) {
				if(numberOfPosition<(numCols*numRows)) {
					return numberOfPosition;
				}
			}
		}else {		
			return generateRandomPosition(numberOfPosition);
		}
		return numberOfPosition;
	}
	
	public void addPlayerScore(String nameOfPlayer) {
		playerWinner.setNickname(nameOfPlayer);
		int scoreOfPlayer = playerWinner.getMovementsOfPlayer() * (numCols * numRows);
		Score playerWhoWin = new Score(playerWinner,scoreOfPlayer,getCreationParameters(),getPlayersSymbols());
		if(root == null) {
			root = playerWhoWin;
		}else {
			addPlayerScore(root, playerWhoWin);
		}
	}
	
	public void addPlayerScore(Score currentPlayer, Score playerToAdd) {
		if(currentPlayer.getRight()==null) {
			currentPlayer.setRight(playerToAdd);
		}else {
			addPlayerScore(currentPlayer.getRight(), playerToAdd);
		}if(currentPlayer.getLeft()!=null) {
			currentPlayer.setLeft(playerToAdd);
		}else {
			addPlayerScore(currentPlayer.getLeft(),playerToAdd);
		}
	}

	
	public String getPlayersSymbols() {
		return obtainAllSymbolsPlayers(firstPlayer);
	}
	
	public String obtainAllSymbolsPlayers(Player currentPlayer) {
		String msg = currentPlayer.getSymbol();
		if(currentPlayer.getprev()!=firstPlayer) {
			msg += obtainAllSymbolsPlayers(currentPlayer.getnext());
		}
		return msg;
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
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public Player getPlayerWinner() {
		return playerWinner;
	}

	public void setPlayerWinner(Player playerWinner) {
		this.playerWinner = playerWinner;
	}

	public String getCreationParameters() {
		return creationParameters;
	}

	public void setCreationParameters(String creationParameters) {
		this.creationParameters = creationParameters;
	}

	public String toString() {
		String msg;
		msg = toStringRow(firstGrid);
		return msg;
	}

	private String toStringRow(Grid firstRow) {
		String msg = "";
		if(firstRow!=null) {
		msg = toStringCol(firstRow);
		msg = toStringRow(firstRow.getDown())+"\n"+msg;
		}
		return msg;
	}
	
	private String toStringCol(Grid current) {
		String msg = "";
		if(current!=null) {
		msg += current.toString();
		msg += toStringCol(current.getNext());
		}
		return msg;
	}
	
	public String toStringWithoutNumber() {
		String msg;
		msg = toStringRowWn(firstGrid);
		return msg;
	}

	private String toStringRowWn(Grid firstRow) {
		String msg = "";
		if(firstRow!=null) {
		msg = toStringColWn(firstRow);
		msg = toStringRowWn(firstRow.getDown())+"\n"+msg;
		}
		return msg;
	}
	
	private String toStringColWn(Grid current) {
		String msg = "";
		if(current!=null) {
		msg += current.toStringWithoutNumber();
		msg += toStringColWn(current.getNext());
		}
		return msg;
	}
	
	public Score getRoot() {
		return root;
	}

	public void setRoot(Score root) {
		this.root = root;
	}

	public String getGameInitiationParameters() {
		return gameInitiationParameters;
	}

	public void setGameInitiationParameters(String gameInitiationParameters) {
		this.gameInitiationParameters = gameInitiationParameters;
	}


	
	
}
