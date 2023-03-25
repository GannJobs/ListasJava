package src;

import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] player1Board = new char[6][6];
        char[][] player2Board = new char[6][6];
        char[][] player1TargetBoard = new char[6][6];
        char[][] player2TargetBoard = new char[6][6];

        // Inicializa os tabuleiros com "-"
        for (int i = 0; i < player1Board.length; i++) {
            for (int j = 0; j < player1Board[i].length; j++) {
                if (i == 0 && j == 0) {
                    player1Board[i][j] = ' ';
                    player2Board[i][j] = ' ';
                    player1TargetBoard[i][j] = ' ';
                    player2TargetBoard[i][j] = ' ';
                } else if (i == 0) {
                    char a = (char) (j+48);
                    player1Board[i][j] = a;
                    player2Board[i][j] = a;
                    player1TargetBoard[i][j] = a;
                    player2TargetBoard[i][j] = a;
                } else if (j == 0) {
                    char a = (char) (i+48);
                    player1Board[i][j] = a;
                    player2Board[i][j] = a;
                    player1TargetBoard[i][j] = a;
                    player2TargetBoard[i][j] = a;
                } else {
                    player1Board[i][j] = '-';
                    player2Board[i][j] = '-';
                    player1TargetBoard[i][j] = '-';
                    player2TargetBoard[i][j] = '-';
                }
            }
        }

        // Imprime o tabuleiro do jogador 1
        System.out.println();
        System.out.println("Player 1 board:");
        for (int i = 0; i < player1Board.length; i++) {
            for (int j = 0; j < player1Board[i].length; j++) {
                System.out.print(player1Board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Imprime a mensagem de boas-vindas
        System.out.println("Welcome to Battleship!!!");
        System.out.println();
        System.out.println("Round to Define Posicion of Ships!");
        System.out.println();
        // Obtém as coordenadas dos navios do jogador 1
        int shipsPlaced = 0;
        while (shipsPlaced < 5) {
            System.out.println("Player 1, enter coordinates for ship " + (shipsPlaced + 1) + " (e.x. 2 3): ");
            int x = input.nextInt();
            int y = input.nextInt();
            if (x < 1 || x > 5 || y < 1 || y > 5) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            } else if (player1Board[x][y] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
            } else {
                player1Board[x][y] = '@';
                shipsPlaced++;
            }
        }

        // Imprime o tabuleiro do jogador 1
        System.out.println();
        System.out.println("Player 1 board:");
        for (int i = 0; i < player1Board.length; i++) {
            for (int j = 0; j < player1Board[i].length; j++) {
                System.out.print(player1Board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Obtém as coordenadas dos navios do jogador 2
        shipsPlaced = 0;
        while (shipsPlaced < 5) {
            System.out.println("Player 2, enter coordinates for ship " + (shipsPlaced + 1) + " (e.x. 2 3): ");
            int x = input.nextInt();
            int y = input.nextInt();
            if (x < 1 || x > 5 || y < 1 || y > 5) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            } else if (player2Board[x][y] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
            } else {
                player2Board[x][y] = '@';
                shipsPlaced++;
            }
        }

        // Imprime o tabuleiro do jogador 1
        System.out.println();
        System.out.println("Player 1 board:");
        for (int i = 0; i < player2Board.length; i++) {
            for (int j = 0; j < player2Board[i].length; j++) {
                System.out.print(player2Board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Inicia a rodada de ataques
        System.out.println();
        System.out.println("Rounds of Attack!");
        System.out.println();

        int ship1 = 5, ship2 = 5; // A quantidade de navios que cada jogador tem

        while (true) { // Enquanto nenhum jogador perder o jogo continuará
            // Turno do Jogador 1
            System.out.println("Player 1 Attack:");
            System.out.println();
            System.out.println("Player 2 board:");
            for (int i = 0; i < player2TargetBoard.length; i++) {
                for (int j = 0; j < player2TargetBoard[i].length; j++) {
                    System.out.print(player2TargetBoard[i][j] + " ");
                }
                System.out.println();
            }
            while (true) {
                System.out.println("Player 1, enter coordinates for the Attack (e.x. 2 3): ");
                int x = input.nextInt();
                int y = input.nextInt();
                if ((x >= 1 && x <= 5) && (y >= 1 && y <= 5)) {
                    if (player2Board[x][y] == '@') {
                        System.out.println("Player 1 hit Player 2 Ship!!!");
                        player2TargetBoard[x][y] = 'X';
                        player2Board[x][y] = 'X';
                        --ship2;
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Player 1 MISSED!");
                        player2TargetBoard[x][y] = 'O';
                        player2Board[x][y] = 'O';
                        System.out.println();
                        break;
                    }
                } else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.println();
                }
            }

            if (ship1 == 0 || ship2 == 0) { // condição de vitoria, algum player perder todos os navios
                break;
            }
            System.out.println();
            // Turno do Jogador 2
            System.out.println("Player 2 Attack:");
            System.out.println();
            System.out.println("Player 1 board:");
            for (int i = 0; i < player1TargetBoard.length; i++) {
                for (int j = 0; j < player1TargetBoard[i].length; j++) {
                    System.out.print(player1TargetBoard[i][j] + " ");
                }
                System.out.println();
            }
            while (true) {
                System.out.println("Player 2, enter coordinates for the Attack (e.x. 2 3): ");
                int x = input.nextInt();
                int y = input.nextInt();
                System.out.println();
                if ((x >= 1 && x <= 5) && (y >= 1 && y <= 5)) {
                    if (player1Board[x][y] == '@') {
                        System.out.println("Player 2 hit Player 1 Ship!!!");
                        player1TargetBoard[x][y] = 'X';
                        player1Board[x][y] = 'X';
                        System.out.println();
                        --ship1;
                        break;
                    } else {
                        System.out.println("Player 2 MISSED!");
                        player1TargetBoard[x][y] = 'O';
                        player1Board[x][y] = 'O';
                        System.out.println();
                        break;
                    }
                } else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.println();
                }
            }

            if (ship1 == 0 || ship2 == 0) { // condição de vitoria, algum player perder todos os navios
                break;
            }

        }
        System.out.println();
        if (ship2 == 0) { // condição de vitoria, algum player perder todos os navios
            System.out.println("Player 1 WIN!");
            // Imprime o tabuleiro do jogador 1
            System.out.println("Player 1 board:");
            for (int i = 0; i < player1Board.length; i++) {
                for (int j = 0; j < player1Board[i].length; j++) {
                    System.out.print(player1Board[i][j] + " ");
                }
                System.out.println();
            }
            // Imprime o tabuleiro final do jogador 2
            System.out.println("Player 2 board:");
            for (int i = 0; i < player2Board.length; i++) {
                for (int j = 0; j < player2Board[i].length; j++) {
                    System.out.print(player2Board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Player 2 WIN!");
            System.out.println();
            // Imprime o tabuleiro final do jogador 2
            System.out.println("Player 2 board:");
            for (int i = 0; i < player2Board.length; i++) {
                for (int j = 0; j < player2Board[i].length; j++) {
                    System.out.print(player2Board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            // Imprime o tabuleiro final do jogador 1
            System.out.println("Player 1 board:");
            for (int i = 0; i < player1Board.length; i++) {
                for (int j = 0; j < player1Board[i].length; j++) {
                    System.out.print(player1Board[i][j] + " ");
                }
                System.out.println();
            }
        }

        input.close();
    }
}
