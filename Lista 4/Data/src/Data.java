public class Data {
    private int dia;
    private int mes;
    private int ano;

    public void inicializarData(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public boolean verificarData() {
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 0) {
            return false;
        }

        switch (mes) {
            case 2:
                if (dia > 29 || (dia == 29 && !isAnoBissexto())) {
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia > 30) {
                    return false;
                }
                break;
        }

        return true;
    }

    private boolean isAnoBissexto() {
        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
            return true;
        }
        return false;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void imprimirData() {
        System.out.printf("%02d/%02d/%04d", dia, mes, ano);
    }

    public void imprimirDataExtenso() {
        String[] meses = { "janeiro", "fevereiro", "março", "abril", "maio", "junho",
                "julho", "agosto", "setembro", "outubro", "novembro", "dezembro" };
        System.out.printf("%02d de %s de %04d", dia, meses[mes - 1], ano);
    }
}
