public class Lampada {

    private int potencia = 0;
    private String estadoDaLampada = "apagado";

    void estado(int pot) {
        if (pot + potencia > 100 || pot - potencia < 0) {
            System.out.printf("A lampada ira queimar com estes valores, selecione entre 0 e 100");
        } else {
            potencia += pot;
            if (potencia >= 50) {
                this.estadoDaLampada = "acesa";
            } else {
                this.estadoDaLampada = "apagada";
            }
        }
    }

    boolean estaLigada() {
        if (this.estadoDaLampada == "acesa") {
            return true;
        } else {
            return false;
        }
    }

    void mostraEstado() {
        if (this.estadoDaLampada == "acesa") {
            System.out.printf("A lampada esta acesa!");
        } else {
            System.out.printf("A lampada esta apagada!");
        }
    }

}
