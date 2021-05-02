package ui;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args){
		System.out.println("\t=================================");
		System.out.println("\t| Welcome to Snakes and Ladders |");
		System.out.println("\t=================================");
		Menu m = new Menu();
		try {
			m.startProgram();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}//End main
}//End Main Class
