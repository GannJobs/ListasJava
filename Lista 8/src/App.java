public class App {
    public static void main(String[] args) throws Exception {
        // DATA HORA
        DataHora dataHora1 = new DataHora(12, 5, 2023, 10, 30, 0);
        DataHora dataHora2 = new DataHora(15, 5, 2023, 9, 45, 0);

        System.out.println("DataHora 1:");
        System.out.println(dataHora1.toString());

        System.out.println("\nDataHora 2:");
        System.out.println(dataHora2.toString());

        if (dataHora1.isEqual(dataHora2)) {
            System.out.println("\nAs datas e horas são iguais.");
        } else if (dataHora1.isGreather(dataHora2)) {
            System.out.println("\nDataHora 1 é maior que DataHora 2.");
        } else if (dataHora1.isLower(dataHora2)) {
            System.out.println("\nDataHora 1 é menor que DataHora 2.");
        }

        // SegmentoReta
        SegmentoReta segmento = new SegmentoReta(0, 3, 0, 4);
        System.out.println(segmento.toString());

        // triangulo
        Ponto2D pontoA = new Ponto2D(0, 0);
        Ponto2D pontoB = new Ponto2D(3, 0);
        Ponto2D pontoC = new Ponto2D(0, 4);

        Triangulo triangulo = new Triangulo(pontoA, pontoB, pontoC);

        triangulo.imprimeTriangulo();

        if (triangulo.isTrianguloRetangulo()) {
            System.out.println("O triângulo é retângulo.");
        } else if (triangulo.isTrianguloIsosceles()) {
            System.out.println("O triângulo é isósceles.");
        } else if (triangulo.isTrianguloEquilatero()) {
            System.out.println("O triângulo é equilátero.");
        } else {
            System.out.println("O triângulo não se enquadra em nenhuma das categorias.");
        }

        // AGENDAMENTO
        // Criando uma data
        Data data = new Data(28, 5, 1990);
        Data data2 = new Data(15, 9, 2023);

        // Criando um horário
        Time horario = new Time(14, 30);

        // Criando um contato
        Contato contato = new Contato("João", "aaaa@aaaa.com", "123456789", data);

        // Criando um agendamento
        Agendamento agendamento = new Agendamento(data2, horario, contato);

        // Imprimindo o agendamento
        agendamento.imprimirAgendamento();
    }
}
