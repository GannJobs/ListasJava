public class App {
    public static void main(String[] args) throws Exception {
        // Criando instâncias da classe Time
        Time time1 = new Time();
        Time time2 = new Time(9);
        Time time3 = new Time(11, 30);
        Time time4 = new Time(14, 45, 30);

        // Exibindo informações sobre os tempos
        System.out.println("Time 1: " + time1.getTime());
        System.out.println("Time 2: " + time2.getTime());
        System.out.println("Time 3: " + time3.getTime());
        System.out.println("Time 4: " + time4.getTime());

        // Verificando se é AM ou PM
        System.out.println("Time 1 is AM: " + time1.isAM());
        System.out.println("Time 2 is AM: " + time2.isAM());
        System.out.println("Time 3 is AM: " + time3.isAM());
        System.out.println("Time 4 is AM: " + time4.isAM());

        // Calculando a diferença entre dois tempos
        Time time5 = new Time(10, 30, 0);
        int diff = time4.cron(time5);
        System.out.println("Difference between Time 4 and Time 5: " + diff + " seconds");

        // Adicionando segundos a um tempo
        Time time6 = new Time(15, 0, 0);
        time6.addSeconds(3600); // Adicionando 1 hora
        System.out.println("Updated Time 6: " + time6.getTime());

        // Criando objetos Data
        Data data1 = new Data(); // Data padrão: 01/01/1970
        Data data2 = new Data(25, 12, 2023); // Data personalizada: 25/12/2023

        // Exibindo as datas
        System.out.print("Data 1: ");
        data1.imprimirData(); // Saída: 01/01/1970
        System.out.print("\nData 2: ");
        data2.imprimirData(); // Saída: 25/12/2023

        // Verificando se uma data é anterior a outra
        boolean anterior = data1.isPrevious(data2);
        System.out.println("\nData 1 é anterior a Data 2? " + anterior); // Saída: Data 1 é anterior a Data 2? true

        // Obtendo o dia da semana
        String diaSemana = data2.dayOfWeek();
        System.out.println("Dia da semana da Data 2: " + diaSemana); // Saída: Dia da semana da Data 2: domingo

        // Calculando a diferença em dias entre duas datas
        int dias = data1.howManyDays(data2);
        System.out.println("Diferença em dias entre Data 1 e Data 2: " + dias + " dias"); // Saída: Diferença em dias
                                                                                          // entre Data 1 e Data 2:
                                                                                          // 19703 dias

        // Obtendo a data atual
        Data dataAtual = Data.getDataAtual();
        System.out.println("Data atual: ");
        dataAtual.imprimirData(); // Saída: Data atual: <data atual no formato dd/MM/yyyy>

        // Criando objetos Data para as datas de nascimento
        Data dataNascimento1 = new Data(15, 5, 1990);
        Data dataNascimento2 = new Data(10, 3, 1985);

        // Criando objetos Contato
        Contato contato1 = new Contato("Joao", "joao@example.com", "123456789000", dataNascimento1);
        Contato contato2 = new Contato("Maria", "maria@example.com", "98765432000", dataNascimento2);

        // Exibindo os contatos
        System.out.println("Contato 1:");
        contato1.imprimirContato();
        System.out.println("\nContato 2:");
        contato2.imprimirContato();

        // Calculando a idade dos contatos
        int idadeContato1 = contato1.calcularIdade();
        int idadeContato2 = contato2.calcularIdade();
        System.out.println("\nIdade do Contato 1: " + idadeContato1 + " anos");
        System.out.println("Idade do Contato 2: " + idadeContato2 + " anos");

        // Criando instâncias da classe Ponto2D
        Ponto2D pontoA = new Ponto2D(2, 3);
        Ponto2D pontoB = new Ponto2D(-4, 1);
        Ponto2D pontoC = new Ponto2D(0, 0);

        // Imprimindo
        pontoA.imprimirPonto();
        pontoB.imprimirPonto();
        pontoC.imprimirPonto();

        // verificando se esta nos eixos
        System.out.println("Ponto A está no eixo X? " + pontoA.isEixoX());
        System.out.println("Ponto B está no eixo Y? " + pontoB.isEixoY());
        System.out.println("Ponto C está nos eixos? " + pontoC.isEixos());

        // verificando em quais quadrantes esta
        System.out.println("Quadrante do ponto A: " + pontoA.quadrante());
        System.out.println("Quadrante do ponto B: " + pontoB.quadrante());
        System.out.println("Quadrante do ponto C: " + pontoC.quadrante());

        // verificando a distancia de pontos
        System.out.println("Distância entre os pontos A e B: " + pontoA.distancia(pontoB));
        System.out.println("Distância entre o ponto A e a origem: " + pontoA.distancia());
        System.out.println("Distância entre o ponto B e as coordenadas (1, 2): " + pontoB.distancia(1, 2));

        // Criando instâncias da classe Circulo
        Circulo circulo1 = new Circulo(2.0, 3.0, 5.0);
        Circulo circulo2 = new Circulo();
        Circulo circulo3 = new Circulo(1.0, 2.0);
        Circulo circulo4 = new Circulo(3.0);

        // Imprimindo informações sobre os círculos
        circulo1.imprimirCirculo();
        circulo2.imprimirCirculo();
        circulo3.imprimirCirculo();
        circulo4.imprimirCirculo();

        // Verificando se um ponto está dentro de um círculo
        Ponto2D ponto = new Ponto2D((float)1, (float)2);
        boolean isPontoInside = circulo1.isInnerPoint(ponto);
        System.out.println("O ponto está dentro do círculo? " + isPontoInside);

        // Calculando a área e o perímetro de um círculo
        double areaCirculo = circulo1.area();
        double perimetroCirculo = circulo1.perimeter();
        System.out.println("Área do círculo: " + areaCirculo);
        System.out.println("Perímetro do círculo: " + perimetroCirculo);

        // Verificando qual círculo é maior em área
        boolean isCirculo1Bigger = circulo1.isBiggerThan(circulo2);
        System.out.println("O círculo 1 é maior que o círculo 2? " + isCirculo1Bigger);
    }
}
