import java.lang.Math;

public class Ponto2D {
    private final float x;
    private final float y;

    public Ponto2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void imprimirPonto() {
        System.out.println("(" + x + ", " + y + ")");
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

    public int quadrante() {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    public float distancia(Ponto2D p) {
        float dx = x - p.getX();
        float dy = y - p.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
