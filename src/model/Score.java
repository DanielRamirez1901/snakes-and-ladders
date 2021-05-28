
package model;

public class Score {	
	private Player player;
	private int score;
	private String parameters;
	private String playersSymbols;	
	private Score parent;
	private Score right;
	private Score left;

	
	public Score(Player player, int score, String parameters, String playersSymbols) {
		this.player = player;
		this.score = score;
		this.parameters = parameters;
		this.playersSymbols = playersSymbols;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getParameters() {
		return parameters;
	}


	public void setParameters(String parameters) {
		this.parameters = parameters;
	}


	public String getPlayersSymbols() {
		return playersSymbols;
	}


	public void setPlayersSymbols(String playersSymbols) {
		this.playersSymbols = playersSymbols;
	}


	public Score getParent() {
		return parent;
	}


	public void setParent(Score parent) {
		this.parent = parent;
	}


	public Score getRight() {
		return right;
	}


	public void setRight(Score right) {
		this.right = right;
	}


	public Score getLeft() {
		return left;
	}


	public void setLeft(Score left) {
		this.left = left;
	}
	
	public String showDataScore(){
        String dataScore;
        
        dataScore = "-------------------------------------------";
        dataScore+= "\n**************PLAYER**************";
        dataScore+= "\n** Nickname: "+player.getNickname();
        dataScore+= "\n** Simbolo: "+player.getSymbol();
        dataScore+= "\n** Puntaje: "+getScore();
        dataScore+= "\n** Parametros de juego: "+getParameters();
        
        return dataScore;
    }
	

}
