package model;

public class Player {
	
	private String nickname;
	private int score;
	private String symbol;
	
	
	public Player(String nickname, int score, String symbol) {
		this.nickname = nickname;
		this.score = score;
		this.symbol = symbol;
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

}
