import random

def craps():
    #estágio 1
    dado1 = random.randint(1, 6)
    dado2 = random.randint(1, 6)
    print(f"Dado 1: {dado1}, Dado 2: {dado2}")
    ponto = dado1 + dado2
    print(f"Ponto: {ponto}")
    if ponto == 11 or ponto == 7:
        print("Você Venceu, que Sortudo!!!")
        return
    if ponto == 2 or ponto == 3 or ponto == 12:
        print("Você Perdeu que azar...")
        return
    #estagio 2
    print("Iniciado estágio 2")
    a = 1
    while True:
        dado1 = random.randint(1, 6)
        dado2 = random.randint(1, 6)
        print(f"Dado 1: {dado1}, Dado 2: {dado2}")
        print(f"Jogada {a}: {dado1 + dado2}")
        if ponto == dado1 + dado2:
            print("Você Venceu, que Sortudo!!!")
            break
        if 7 == dado1 + dado2:
            print("Você Perdeu que azar...")
            break
        a += 1

craps()