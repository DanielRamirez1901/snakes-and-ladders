package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Board;
import model.Score;

public class Menu {

    private final static int START = 1;
    private final static int SHOW = 2;
    private final static int EXIT = 3;

    private Score info;

    private BufferedReader br;

    Board board;

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
                        System.out.println("\nIngrese los siguientes datos en una sola linea (separados por espacios): "
                                + "\n\n*Numero de filas y columnas."
                                + "\n*Serpientes y escaleras."
                                + "\n*Numero de jugadores."
                                + "\n*Symbolos de jugadores (opcional).");
                        String data = br.readLine();
                        String[] parts = data.split(" ");
                        if (parts.length == 5) {
                            initializateGame(parts);
                            //System.out.println(imprimeTablero);
                            String turno = br.readLine();
                            progressToGame(turno);
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

    private void initializateGame(String[] parts) {
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int snakes = Integer.parseInt(parts[2]);
        int ladders = Integer.parseInt(parts[3]);
        char[] players = parts[4].toCharArray();

        //matriz = new matriz(n, m, numSnake, numLadders, players);
    }

    public void dataPlayerWinner() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digita el nombre del ganador: ");
        String name = br.readLine();
        //savedGames.addPlayerWinner(newGame.getCurrentGame(), nick);
        startProgram();
        br.close();
    }

    private void progressToGame(String input) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        if (input.equals("")) {

            //System.out.println();lanzar dados

            if ("ganador" != null) {
                line = "leave";
                progressToGame(line);
            } else {
                line = br.readLine();
                progressToGame(line);
            }

        } else if (input.equals("num")) {

            System.out.println("imprimir tablero");
            line = br.readLine();
            progressToGame(line);

        } else if (input.equals("simul")) {

            //

        } else if (input.equals("menu")) {

            startProgram();

        } else if (input.equals("leave")) {
            dataPlayerWinner();
        }

        br.close();
    }

}
