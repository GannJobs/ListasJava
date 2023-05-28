public class App {
    public static void main(String[] args) throws Exception {
        // Criar uma instância da classe Contato
        Data dataNascimento = new Data(15, 5, 1990); // Supondo que a classe Data já existe
        Contato contato = new Contato("João", "joao@example.com", "1234567890", dataNascimento);

        // Imprimir informações do contato
        contato.imprimirContato();

        // Calcular e imprimir a idade do contato
        int idade = contato.calcularIdade();
        System.out.println("Idade: " + idade);

        // Alterar o nome do contato e imprimir novamente
        contato.setNome("José");
        contato.imprimirContato();

        // Obter o número total de contatos criados
        int totalContas = Contato.Ncontas();
        System.out.println("Total de contas: " + totalContas);

        // Criar uma instância da classe Time
        Time t1 = new Time(10, 30, 45);
        Time t2 = new Time(15, 20);
        Time t3 = new Time();

        // Imprimir o tempo
        System.out.println("Tempo t1: " + t1.getTime());
        System.out.println("Tempo t2: " + t2.getTime());
        System.out.println("Tempo t3: " + t3.getTime());

        // Verificar se é AM ou PM
        System.out.println("t1 é AM? " + t1.isAM());
        System.out.println("t2 é AM? " + t2.isAM());

        // Calcular a diferença entre dois tempos
        Time diff = Time.diffTime(t1, t2);
        System.out.println("Diferença entre t1 e t2: " + diff.getTime());

        // Adicionar segundos a um tempo
        t1.addSeconds(3600); // Adicionar 1 hora a t1
        System.out.println("Tempo t1 após adicionar 1 hora: " + t1.getTime());

        // Definir um novo tempo
        t3.setTime(23, 45, 30);
        System.out.println("Novo tempo t3: " + t3.getTime());

        // Verificar se um tempo é AM ou PM
        System.out.println("t3 é AM? " + Time.isAm(t3));
        System.out.println("t3 é PM? " + Time.isPm(t3));

        // Criação de objetos Data
        Data data1 = new Data(15, 6, 2023);
        Data data2 = new Data(1, 1, 2023);

        // Imprime as datas
        System.out.println("Data 1: " + Data.dayToPrintLong(data1));
        System.out.println("Data 2: " + Data.dayToPrintLong(data2));

        // Verifica se uma data é anterior à outra
        if (data1.isPrevious(data2)) {
            System.out.println("Data 1 é anterior à Data 2");
        } else {
            System.out.println("Data 1 não é anterior à Data 2");
        }

        // Obtém o dia da semana de uma data
        String diaDaSemana = Data.dayOfWeek(data1);
        System.out.println("Dia da semana da Data 1: " + diaDaSemana);

        // Calcula a quantidade de dias entre duas datas
        int diasEntreDatas = data1.howManyDays(data2);
        System.out.println("Dias entre Data 1 e Data 2: " + diasEntreDatas);

        // Obtém a data atual
        Data dataAtual = Data.getDataAtual();
        System.out.println("Data atual: " + Data.dayToPrintShort(dataAtual));

        // Calcula a quantidade de dias até o final do ano a partir de uma data
        int diasAteFinalDoAno = Data.howManyDaysUntilEndYear(data1);
        System.out.println("Dias até o final do ano a partir da Data 1: " + diasAteFinalDoAno);

        // Criando pontos
        Ponto2D ponto1 = new Ponto2D(2, 3);
        Ponto2D ponto2 = new Ponto2D(-4, 1);

        // Imprimindo os pontos
        System.out.print("Ponto 1: ");
        ponto1.imprimirPonto();
        System.out.print("Ponto 2: ");
        ponto2.imprimirPonto();

        // Calculando a distância entre os pontos
        float distancia = Ponto2DBlib.distance(ponto1, ponto2);
        System.out.println("Distância entre os pontos: " + distancia);

        // Calculando a distância entre um ponto e a origem
        float distanciaOrigem = Ponto2DBlib.distance(ponto1);
        System.out.println("Distância do Ponto 1 à origem: " + distanciaOrigem);

        // Verificando o quadrante de um ponto
        int quadrante = Ponto2DBlib.quadrant(ponto2);
        System.out.println("Quadrante do Ponto 2: " + quadrante);

        double pesoEmGramas = 500;

        // Convertendo de gramas para quilogramas
        double pesoEmQuilogramas = PesoConversoes.gramsToKilograms(pesoEmGramas);
        System.out.println(pesoEmGramas + " gramas equivalem a " + pesoEmQuilogramas + " quilogramas.");

        // Convertendo de gramas para onças
        double pesoEmOunces = PesoConversoes.gramsToOunces(pesoEmGramas);
        System.out.println(pesoEmGramas + " gramas equivalem a " + pesoEmOunces + " onças.");

        // Convertendo de gramas para libras
        double pesoEmPounds = PesoConversoes.gramsToPounds(pesoEmGramas);
        System.out.println(pesoEmGramas + " gramas equivalem a " + pesoEmPounds + " libras.");

        // Convertendo de quilogramas para gramas
        double pesoEmGramas2 = PesoConversoes.kilogramsToGrams(pesoEmQuilogramas);
        System.out.println(pesoEmQuilogramas + " quilogramas equivalem a " + pesoEmGramas2 + " gramas.");

        // Convertendo de quilogramas para libras
        double pesoEmPounds2 = PesoConversoes.kilogramsToPounds(pesoEmQuilogramas);
        System.out.println(pesoEmQuilogramas + " quilogramas equivalem a " + pesoEmPounds2 + " libras.");

        // Convertendo de quilogramas para onças
        double pesoEmOunces2 = PesoConversoes.kilogramsToOunces(pesoEmQuilogramas);
        System.out.println(pesoEmQuilogramas + " quilogramas equivalem a " + pesoEmOunces2 + " onças.");

        // Convertendo de libras para gramas
        double pesoEmGramas3 = PesoConversoes.poundsToGrams(pesoEmPounds);
        System.out.println(pesoEmPounds + " libras equivalem a " + pesoEmGramas3 + " gramas.");

        // Convertendo de libras para quilogramas
        double pesoEmQuilogramas3 = PesoConversoes.poundsToKilograms(pesoEmPounds);
        System.out.println(pesoEmPounds + " libras equivalem a " + pesoEmQuilogramas3 + " quilogramas.");

        // Convertendo de libras para onças
        double pesoEmOunces3 = PesoConversoes.poundsToOunces(pesoEmPounds);
        System.out.println(pesoEmPounds + " libras equivalem a " + pesoEmOunces3 + " onças.");

        // Convertendo de onças para gramas
        double pesoEmGramas4 = PesoConversoes.ounceToGrams(pesoEmOunces);
        System.out.println(pesoEmOunces + " onças equivalem a " + pesoEmGramas4 + " gramas.");

        // Convertendo de onças para quilogramas
        double pesoEmQuilogramas4 = PesoConversoes.ounceToKilograms(pesoEmOunces);
        System.out.println(pesoEmOunces + " onças equivalem a " + pesoEmQuilogramas4 + " quilogramas.");

        // Convertendo de onças para libras
        double pesoEmPounds4 = PesoConversoes.ounceToPounds(pesoEmOunces);
        System.out.println(pesoEmOunces + " onças equivalem a " + pesoEmPounds4 + " libras.");
    }
}
