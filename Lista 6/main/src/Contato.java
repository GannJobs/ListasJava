public class Contato {
    private String nome;
    private String email;
    private String telefone;
    private Data dataNascimento;

    public Contato(String nome, String email, String telefone, Data dataNascimento) {
        if (validaNome(nome) && validaEmail(email) && validaTelefone(telefone)
                && dataNascimento.verificarData(dataNascimento.getDia(), dataNascimento.getMes(), dataNascimento.getAno())) {
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.dataNascimento = dataNascimento;
        } else {
            System.out.println("Valores invalidos");
        }
    }

    private boolean validaNome(String nome) {
        if (nome.length() >= 2) {
            return true;
        }
        return false;
    }

    private boolean validaEmail(String email) {
        if (email.length() >= 8) {
            return true;
        }
        return false;
    }

    private boolean validaTelefone(String telefone) {
        if (telefone.length() >= 11) {
            return true;
        }
        return false;
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

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void imprimirContato() {
        System.out.println("Nome: " + this.nome);
        System.out.println("E-mail: " + this.email);
        System.out.println("Telefone: " + this.telefone);
        System.out.print("Data Nascimento: ");
        dataNascimento.imprimirDataExtenso();
    }

    public int calcularIdade() {
        int idade = 0;
        Data data = new Data();
        data = Data.getDataAtual();
        while (data.getAno() > dataNascimento.getAno()) {
            idade++;
            data.setAno(data.getAno() - 1);
        }
        if (data.getMes() <= dataNascimento.getMes()) {
            idade--;
        }
        if (data.getMes() == dataNascimento.getMes() && data.getDia() >= dataNascimento.getDia()) {
            idade++;
        }
        return idade;
    }
}
