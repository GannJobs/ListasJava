public class Circulo {
    private double x;
    private double y;
    private double r;

    public Circulo(double x, double y, double r) {
        if (validaCirculo(x, y, r)) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public boolean validaCirculo(double x, double y, double r) {
        return r > 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        if (r > 0) {
            this.r = r;
        }
    }

    public void imprimirCirculo() {
        System.out.printf("Círculo de centro (%.2f, %.2f) e raio %.2f\n", x, y, r);
    }

    public boolean isInnerPoint(Ponto2D ponto) {
        double distancia = Math.sqrt(Math.pow(ponto.getX() - x, 2) + Math.pow(ponto.getY() - y, 2));
        return distancia < r;
    }

    public double area() {
        return Math.PI * Math.pow(r, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * r;
    }

    public boolean isBiggerThan(Circulo outroCirculo) {
        return this.area() > outroCirculo.area();
    }
}
