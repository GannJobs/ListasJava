public class SegmentoReta {
    private Ponto2D inicio;
    private Ponto2D fim;

    // COMPOSIÇÂO
    public SegmentoReta(float x1, float x2, float y1, float y2){
        inicio = new Ponto2D(x1,y1);
        fim = new Ponto2D(x2,y2);
        dimensao();
    }

    public String toString(){
        return "\nInicio da Reta: " + inicio.imprimirPonto() + "\nFinal da Reta: " + fim.imprimirPonto();
    }

    private String dimensao(){
        float dx = inicio.getX() - fim.getX();
        float dy = inicio.getY() - fim.getY();
        return "A dimensao da reta é o seu comprimento(distancia entre os pontos do inicio e fim)" + (float) Math.sqrt(dx * dx + dy * dy);
    }

    // AGREGAÇÂO
    // public SegmentoReta(Ponto2D p1, Ponto2D p2){
    //     inicio = p1;
    //     fim = p2;
    //     dimensao();
    // }

    // public String toString(){
    //     return "\nInicio da Reta: " + inicio.imprimirPonto() + "\nFinal da Reta: " + fim.imprimirPonto();
    // }

    // private String dimensao(){
    //     float dx = inicio.getX() - fim.getX();
    //     float dy = inicio.getY() - fim.getY();
    //     return "A dimensao da reta é o seu comprimento(distancia entre os pontos do inicio e fim)" + (float) Math.sqrt(dx * dx + dy * dy);
    // }
}
