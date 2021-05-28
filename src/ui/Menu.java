package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.*;
public class Menu {

    private final static int START = 1;
    private final static int SHOW = 2;
    private final static int EXIT = 3;

    private Score info;

    private BufferedReader br;

    private Board board;

    public Menu() {
        br = new BufferedReader(new InputStreamReader(System.in));
        board = new Board();
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
            if (num == START) {
                System.out.println(board);
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated catch block

    }

    public void startProgram() throws NumberFormatException, IOException {
        showMenu();
        Program();
    }

    private void Program() throws IOException {
        int option = readOption();
        if (option != EXIT) {
            try {
                showMenu();

                switch (option) {

                    case START:
                    	System.out.println("A continuacion, presione..."
                    			+ "\n[1] Si desea agregarle simbolos a los jugadores"
                    			+ "\n[2] Si desea que el programa le asigne aleatoriamente simbolos a los jugadores");
                    	int numOption = readOption();
                        System.out.print("\nIngrese los siguientes datos en una sola linea (separados por espacios): "
                                + "\n\n*Numero de filas y columnas."
                                + "\n*Serpientes y escaleras.");
                        	if(numOption==2) 
                               System.out.println("\n*Numero de jugadores.");
                              if(numOption==1) 
                                System.out.println("\n*Symbolos de jugadores.");
                               
                              
                        String data = br.readLine();
                        String[] parts = data.split(" ");
                        if (parts.length == 5) {
                        	if(numOption==1) {
                        		initializateGame1(parts);
                        		System.out.println(board);
                        		String turno = br.readLine();
                        		System.out.println(board.toStringWithoutNumber());
                        		progressToGame(turno);
                        	}if(numOption==2) {
                        		initializateGame2(parts);
                        		System.out.println(board);
                        		String turno = br.readLine();
                        		System.out.println(board.toStringWithoutNumber());
                        		System.out.println(board.rollingTheDice());
                        		progressToGame(turno);
                        	}
                        } else {
                            startProgram();
                        }

                        break;

                    case SHOW:
                        System.out.println(info.showDataScore());
                        startProgram();
                        break;

                }

                //doOperation(option);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            startProgram();

        }

    }
//                    	System.out.println("A continuacion, presione..."
//                    			+ "\n[1] Si desea agregarle simbolos a los jugadores"
//                    			+ "\n[2] Si desea que el programa le asigne aleatoriamente simbolos a los jugadores");
//                    	int numOption = readOption();
//                    	if(numOption == 1) {
//                        System.out.println("\nIngrese los siguientes datos en una sola linea (separados por un espacio): "
//                                + "\n\n*Numero de filas y columnas."
//                                + "\n*Serpientes y escaleras."
//                                + "\n*Symbolos de jugadores (opcional).");
//                        String data = br.readLine();
//                        String[] parts = data.split(" ");
//                        if (parts.length == 5) {
//                			initializateGame1(parts);
//                        }
////                        else{
////                    		System.out.println("\nIngrese los siguientes datos en una sola linea (separados por un espacio): "
////                    				+ "\n\n*Numero de filas y columnas."
////                    				+ "\n*Serpientes y escaleras."
////                    				+ "\n*Numero de jugadores.");
////                    		String data2 = br.readLine();
////                    		String[] parts2 = data2.split(" ");
////                    		if (parts.length == 5) {
////                    			initializateGame2(parts2);
////                    		}
////                    	}
       		
    

    private void initializateGame1(String[] parts) {
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int snakes = Integer.parseInt(parts[2]);
        int ladders = Integer.parseInt(parts[3]);
        String symbol = parts[4];
        board.createGameWithPlayersSymbol(n, m, snakes, ladders, symbol);
    }

    private void initializateGame2(String[] parts) {
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int snakes = Integer.parseInt(parts[2]);
        int ladders = Integer.parseInt(parts[3]);
        int amountPlayers = Integer.parseInt(parts[4]);  
        board.createGameWithAmountPlayers(n, m, snakes, ladders, amountPlayers);
    }
    
   
    public void dataPlayerWinner() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(board.showWinnerInformation());
        System.out.println("Digita el nombre del ganador: ");
        String name = br.readLine();
        board.addPlayerScore(name);
        startProgram();
        br.close();
    }

    private void progressToGame(String input) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        if (input.equals("")) {

    		System.out.println(board.rollingTheDice());
    		System.out.println(board.toStringWithoutNumber());

            if (board.getPlayerWinner() != null) {
                line = "leave";
                progressToGame(line);
            } else {
                line = br.readLine();
                progressToGame(line);
            }
        } else if (input.equals("num")) {

    		System.out.println(board);
            line = br.readLine();
            progressToGame(line);

        } else if (input.equals("simul")) {

        	System.out.println(board.rollingTheDice());
    		System.out.println(board.toStringWithoutNumber());

        } else if (input.equals("menu")) {

            startProgram();

        } else if (input.equals("leave")) {
            dataPlayerWinner();
        }

        br.close();
    }
 
}
