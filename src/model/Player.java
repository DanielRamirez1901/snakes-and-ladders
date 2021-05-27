package model;

public class Player {
	
	private String nickname;
	private int score;
	private String symbol;
	private Grid positionInGrid;
	private Player next;
	private Player prev;
	private Player nextInGrid;
	private Player prevInGrid;
	private int movementsOfPlayer;
	
	
	public Player(String symbol, Grid position) {
		this.symbol = symbol;
		positionInGrid = position;
	}
	
	public int getNumberOfPosition() {
		return positionInGrid.getGridNumber();
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Grid getPositionInGrid() {
		return positionInGrid;
	}


	public void setPositionInGrid(Grid positionInGrid) {
		this.positionInGrid = positionInGrid;
	}


	public Player getnext() {
		return next;
	}


	public void setnext(Player next) {
		this.next = next;
	}


	public Player getprev() {
		return prev;
	}


	public void setprev(Player prev) {
		this.prev = prev;
	}


	public int getMovementsOfPlayer() {
		return movementsOfPlayer;
	}


	public void setMovementsOfPlayer(int movementsOfPlayer) {
		this.movementsOfPlayer = movementsOfPlayer;
	}

	public Player getNextInGrid() {
		return nextInGrid;
	}

	public void setNextInGrid(Player nextInGrid) {
		this.nextInGrid = nextInGrid;
	}

	public Player getPrevInGrid() {
		return prevInGrid;
	}

	public void setPrevInGrid(Player prevInGrid) {
		this.prevInGrid = prevInGrid;
	}

	
}

