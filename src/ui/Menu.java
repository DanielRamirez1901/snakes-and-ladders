package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Board;


public class Menu {
	
	private final static int START = 1;
//	private final static int SHOW = 2;
	private final static int EXIT = 3;
	
	private BufferedReader br;
	
	Board board;
	
	public Menu() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	

	public void showMenu() {
		System.out.println("[1] Comenzar juego"
				+ "\n[2] Ver tabla de puntuacion"
				+ "\n[3] Salir");
	}

	public int readOption() throws NumberFormatException, IOException {
		int option = Integer.parseInt(br.readLine());
		return option;
	}
	
	public void doOperation(int n) {
		try {
			int num = readOption();
			if(num==START) {
				board = new Board(5,5);
				System.out.println(board);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void startProgram() throws NumberFormatException, IOException  {
		showMenu();
		int option = readOption();
		startProgram(option);
	}

	private void startProgram(int option) {
		if(option != EXIT) {
			showMenu();
			try {
				option = readOption();
				doOperation(option);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			startProgram(option);
		}
	}
	
}
