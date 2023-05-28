public class Ponto2DBlib {
    public static float distance(Ponto2D P1, Ponto2D P2) {
        float dx = P2.getX() - P1.getX();
        float dy = P2.getY() - P1.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public static float distance(Ponto2D P) {
        float dx = P.getX() - 0;
        float dy = P.getY() - 0;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public static int quadrant(Ponto2D P) {
        float x = P.getX();
        float y = P.getY();

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
}
