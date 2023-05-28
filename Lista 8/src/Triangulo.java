public class Triangulo {
    private final Ponto2D pontoA;
    private final Ponto2D pontoB;
    private final Ponto2D pontoC;

    public Triangulo(Ponto2D pontoA, Ponto2D pontoB, Ponto2D pontoC) {
        this.pontoA = pontoA;
        this.pontoB = pontoB;
        this.pontoC = pontoC;
    }

    public void imprimeTriangulo() {
        System.out.println("Ponto A: " + pontoA.imprimirPonto());
        System.out.println("Ponto B: " + pontoB.imprimirPonto());
        System.out.println("Ponto C: " + pontoC.imprimirPonto());
    }

    public boolean isTrianguloRetangulo() {
        double ladoAB = distanciaEntrePontos(pontoA, pontoB);
        double ladoBC = distanciaEntrePontos(pontoB, pontoC);
        double ladoCA = distanciaEntrePontos(pontoC, pontoA);

        return ehTriangulo() && (ehRetangulo(ladoAB, ladoBC, ladoCA) || ehRetangulo(ladoBC, ladoCA, ladoAB) || ehRetangulo(ladoCA, ladoAB, ladoBC));
    }

    public boolean isTrianguloIsosceles() {
        double ladoAB = distanciaEntrePontos(pontoA, pontoB);
        double ladoBC = distanciaEntrePontos(pontoB, pontoC);
        double ladoCA = distanciaEntrePontos(pontoC, pontoA);

        return ehTriangulo() && (ladoAB == ladoBC || ladoBC == ladoCA || ladoCA == ladoAB);
    }

    public boolean isTrianguloEquilatero() {
        double ladoAB = distanciaEntrePontos(pontoA, pontoB);
        double ladoBC = distanciaEntrePontos(pontoB, pontoC);
        double ladoCA = distanciaEntrePontos(pontoC, pontoA);

        return ehTriangulo() && ladoAB == ladoBC && ladoBC == ladoCA;
    }

    private boolean ehTriangulo() {
        return !estaoAlinhados(pontoA, pontoB, pontoC);
    }

    private boolean ehRetangulo(double lado1, double lado2, double lado3) {
        double lado1Quadrado = Math.pow(lado1, 2);
        double lado2Quadrado = Math.pow(lado2, 2);
        double lado3Quadrado = Math.pow(lado3, 2);

        return lado1Quadrado == lado2Quadrado + lado3Quadrado;
    }

    private double distanciaEntrePontos(Ponto2D ponto1, Ponto2D ponto2) {
        double dx = ponto2.getX() - ponto1.getX();
        double dy = ponto2.getY() - ponto1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    private boolean estaoAlinhados(Ponto2D ponto1, Ponto2D ponto2, Ponto2D ponto3) {
        return (ponto2.getY() - ponto1.getY()) * (ponto3.getX() - ponto1.getX()) == (ponto3.getY() - ponto1.getY()) * (ponto2.getX() - ponto1.getX());
    }
}
