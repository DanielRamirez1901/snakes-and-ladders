package model;

public class Grid {
	private int number;
	private Grid up;
	private Grid down;
	private Grid left;
	private Grid right;
	private boolean isOcupated;
	
	Player player;

	
	
	
	
	
	public Grid() {
		isOcupated = false;
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
	
	
}
