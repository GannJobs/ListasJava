public class Ponto2D {
    private final float x;
    private final float y;

    public Ponto2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Ponto2D() {
        this.x = 0;
        this.y = 0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String imprimirPonto() {
        return "(" + x + ", " + y + ")";
    }

    public boolean isEixoX() {
        return y == 0;
    }

    public boolean isEixoY() {
        return x == 0;
    }

    public boolean isEixos() {
        return x == 0 && y == 0;
    }
}
