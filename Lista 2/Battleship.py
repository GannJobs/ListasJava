import numpy as np

def battleship():
    player1Board = np.full((6,6), "-") # Cria uma matriz 6x6 preenchida com "-"
    player2Board = np.full((6,6), "-") # Cria uma matriz 6x6 preenchida com "-"
    player1TargetBoard = np.full((6,6), "-") # Cria uma matriz 6x6 preenchida com "-"
    player2TargetBoard = np.full((6,6), "-") # Cria uma matriz 6x6 preenchida com "-"

    for i in range(len(player1Board)):
        for j in range(len(player1Board[i])):
            if i == 0 and j == 0:
                player1Board[i][j] = ' '
                player2Board[i][j] = ' '
                player1TargetBoard[i][j] = ' '
                player2TargetBoard[i][j] = ' '
            elif i == 0:
                player1Board[i][j] = chr(j+48)
                player2Board[i][j] = chr(j+48)
                player1TargetBoard[i][j] = chr(j+48)
                player2TargetBoard[i][j] = chr(j+48)
            elif j == 0:
                player1Board[i][j] = chr(i+48)
                player2Board[i][j] = chr(i+48)
                player1TargetBoard[i][j] = chr(i+48)
                player2TargetBoard[i][j] = chr(i+48)
            else:
                player1Board[i][j] = '-'
                player2Board[i][j] = '-'
                player1TargetBoard[i][j] = '-'
                player2TargetBoard[i][j] = '-'

    print("Welcome to Battleship!!!")
    print("\nRound to Define Posicion of Ships!")
    print()

    shipsPlaced = 0

    while shipsPlaced < 5:
        print(f"Player 1, enter coordinates for ship {shipsPlaced + 1} (e.x. 2 3): ")
        x, y = input().split()
        x = int(x)
        y = int(y)
        if x < 1 or x > 5 or y < 1 or y > 5:
            print("Invalid coordinates. Choose different coordinates.")
        elif player1Board[x][y] == '@':
            print("You already have a ship there. Choose different coordinates.")
        else:
            player1Board[x][y] = '@'
            shipsPlaced += 1

    print("\nPlayer 1 board:")
    for row in player1Board:
        print(" ".join(row))
    print()

    shipsPlaced = 0


    while shipsPlaced < 5:
        print(f"Player 2, enter coordinates for ship {shipsPlaced + 1} (e.x. 2 3): ")
        x, y = input().split()
        x = int(x)
        y = int(y)
        if x < 1 or x > 5 or y < 1 or y > 5:
            print("Invalid coordinates. Choose different coordinates.")
        elif player2Board[x][y] == '@':
            print("You already have a ship there. Choose different coordinates.")
        else:
            player2Board[x][y] = '@'
            shipsPlaced += 1

    print("\nPlayer 2 board:")
    for row in player2Board:
        print(" ".join(row))
    print()

    print("\nRounds of Attack!\n")

    ship1, ship2 = 5, 5 # A quantidade de navios que cada jogador tem

    while True: # Enquanto nenhum jogador perder o jogo continuará
    # Turno do Jogador 1
        print("Player 1 Attack:")
        print("Player 2 board:")
        for i in player2TargetBoard:
            for j in i:
                print(j, end=" ")
                print()
                while True:
                    x, y = map(int, input("Player 1, enter coordinates for the Attack (e.x. 2 3): ").split())
                    if 1 <= x <= 5 and 1 <= y <= 5:
                        if player2Board[x][y] == "@":
                            print("Player 1 hit Player 2 Ship!!!")
                            player2TargetBoard[x][y] = "X"
                            player2Board[x][y] = "X"
                            ship2 -= 1
                            print()
                            break
                        else:
                            print("Player 1 MISSED!")
                            player2TargetBoard[x][y] = "O"
                            player2Board[x][y] = "O"
                            print()
                            break
                    else:
                        print("Invalid coordinates. Choose different coordinates.\n")

        if ship1 == 0 or ship2 == 0:  # condição de vitoria, algum player perder todos os navios
            break

        # Turno do Jogador 1
        print("Player 2 Attack:")
        print("Player 1 board:")
        for i in player1TargetBoard:
            for j in i:
                print(j, end=" ")
                print()
                while True:
                    x, y = map(int, input("Player 2, enter coordinates for the Attack (e.x. 2 3): ").split())
                    if 1 <= x <= 5 and 1 <= y <= 5:
                        if player1Board[x][y] == "@":
                            print("Player 2 hit Player 1 Ship!!!")
                            player1TargetBoard[x][y] = "X"
                            player1Board[x][y] = "X"
                            ship2 -= 1
                            print()
                            break
                        else:
                            print("Player 2 MISSED!")
                            player1TargetBoard[x][y] = "O"
                            player1Board[x][y] = "O"
                            print()
                            break
                    else:
                        print("Invalid coordinates. Choose different coordinates.\n")

        if ship1 == 0 or ship2 == 0:  # condição de vitoria, algum player perder todos os navios
            break

    if ship2 == 0: # condição de vitoria, algum player perder todos os navios
        print("Player 1 WIN!")
        print()
        # Imprime o tabuleiro do jogador 1
        print("Player 1 board:")
        for i in player1Board:
            for j in i:
                print(j, end=" ")
            print()
            # Imprime o tabuleiro final do jogador 2
            print("Player 2 board:")
        for i in player2Board:
            for j in i:
                print(j, end=" ")
            print()
    else:
        print("Player 2 WIN!")
        print()
    # Imprime o tabuleiro final do jogador 2
        print("Player2 board:")
        for i in player2Board:
            for j in i:
                print(j, end=" ")
            print()
            # Imprime o tabuleiro final do jogador 2
            print("Player 1 board:")
        for i in player1Board:
            for j in i:
                print(j, end=" ")
            print()

battleship()