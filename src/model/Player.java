package model;

public class Player {
	
	private String nickname;
	private int score;
	private String symbol;
	private Player nextPlayerInGrid;
	private Player prevPlayerInGrid;
	private Grid positionInGrid;
	
	
	public Player(String symbol, Grid position) {
		this.symbol = symbol;
		positionInGrid = position;
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


	public Player getNextPlayerInGrid() {
		return nextPlayerInGrid;
	}


	public void setNextPlayerInGrid(Player nextPlayerInGrid) {
		this.nextPlayerInGrid = nextPlayerInGrid;
	}


	public Player getPrevPlayerInGrid() {
		return prevPlayerInGrid;
	}


	public void setPrevPlayerInGrid(Player prevPlayerInGrid) {
		this.prevPlayerInGrid = prevPlayerInGrid;
	}


	public Grid getPositionInGrid() {
		return positionInGrid;
	}


	public void setPositionInGrid(Grid positionInGrid) {
		this.positionInGrid = positionInGrid;
	}
	
	

}
