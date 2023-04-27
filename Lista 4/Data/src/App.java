import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        // data
        Data data = new Data();
        data.inicializarData(26, 4, 2023);
        if (data.verificarData()) {
            System.out.println("Data válida!");
        } else {
            System.out.println("Data inválida!");
        }
        data.imprimirData();
        data.imprimirDataExtenso();
        data.setAno(2022);
        data.imprimirData();
        // contato
        Contato contato = new Contato();
        contato.inicializarContato("João da Silva", "joao.silva@example.com", "(11) 98765-4321",
                LocalDate.of(1990, 8, 23));
        contato.imprimirContato();
        System.out.println("Idade: " + contato.calcularIdade());
        // lampada
        Lampada l = new Lampada();
        l.mostraEstado();
        l.estado(30);
        l.mostraEstado();
        l.estado(50);
        l.mostraEstado();
        boolean ligada = l.estaLigada();
        System.out.println("A lâmpada está ligada? " + ligada);
        // ponto 2d
        Ponto2D p1 = new Ponto2D();
        p1.setX(3);
        p1.setY(4);
        p1.imprimirPonto();
        System.out.println("P1 está no eixo X? " + p1.isEixoX());
        System.out.println("P1 está no eixo Y? " + p1.isEixoY());
        System.out.println("P1 está nos eixos? " + p1.isEixos());
        System.out.println("P1 está no quadrante " + p1.quadrante());
        Ponto2D p2 = new Ponto2D();
        p2.setX(-1);
        p2.setY(2);
        p2.imprimirPonto();
        System.out.println("Distância entre P1 e P2: " + p1.distancia(p2));

    }
}
