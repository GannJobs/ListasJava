import java.time.LocalDate;
import java.time.Period;

public class Contato {
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    public Contato(String nome, String email, String telefone, LocalDate dataNascimento) {
        if (validaNome(nome) && validaEmail(email) && validaTelefone(telefone) && validaDataNasc(dataNascimento)){
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.dataNascimento = dataNascimento;
        }
    }

    private boolean validaNome(String nome){
        if(nome.length()>2){
            return true;
        }
        return false;
    }

    private boolean validaEmail(String email){
        if(email.length()>8){
            return true;
        }
        return false;
    }

    private boolean validaTelefone(String telefone){
        if(telefone.length()>11){
            return true;
        }
        return false;
    }

    private boolean validaDataNasc(LocalDate dataNascimento){
        return dataNascimento != null && !dataNascimento.isAfter(LocalDate.now());
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void imprimirContato() {
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de nascimento: " + dataNascimento);
    }

    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);
        return periodo.getYears();
    }
}
