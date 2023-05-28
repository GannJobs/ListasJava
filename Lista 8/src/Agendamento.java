public class Agendamento {
    private Data data;
    private Time horario;
    private Contato contato;

    public Agendamento(Data data, Time horario, Contato contato) {
        if (validaAgendamento(data)) {
            this.data = data;
            this.horario = horario;
            this.contato = contato;
        }
    }

    private boolean validaAgendamento(Data data) {
        Data data2 = new Data(Data.getDataAtual());
        if (data.getDia() < data2.getDia()) {
            System.out.println("Data Invalida para agendamento, nao pode ser anterior ao dia de hoje!");
            return false;
        }
        return true;
    }

    public void imprimirAgendamento() {
        System.out.println("Agendamento:");
        System.out.println("Data: " + data.imprimirData());
        System.out.println("Horário: " + horario.getTime());
        System.out.println("Contato: " + contato.getNome());
        System.out.println("Telefone: " + contato.getTelefone());
    }
}
