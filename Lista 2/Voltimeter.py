import math

def Voltimeter():
    meds = []
    Smeds = 0
    DPS = 0

    for i in range(10):
        med = float(input("Insira o valor da {}ª medição: ".format(i+1)))
        meds.append(med)
        Smeds += med

    Smeds /= 10

    for i in range(10):
        aux = math.pow(meds[i] - Smeds, 2)
        DPS += aux
        aux = 0

    DesvioPadrao = math.sqrt(DPS / 10)

    if DesvioPadrao > (Smeds*0.1):
        print("O voltimetro esta com problemas")
    else:
        print("O voltimetro esta funcional!")

Voltimeter()
