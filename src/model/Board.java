package model;

public class Board {
	private int n = 0;
	private int m = 0;
	Player player;
	Grid firstGrid;
	
	
	public Board(int a, int b) {	
		n = a;
		m = b;
	}
	
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
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
	
	
}
