import java.time.LocalDate;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    private static String[] diasDaSemana = { "sábado", "domingo", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira",
    "sexta-feira" };
    private static String[] meses = { "janeiro", "fevereiro", "março", "abril", "maio", "junho",
    "julho", "agosto", "setembro", "outubro", "novembro", "dezembro" };

    public Data() {
        this.dia = 1;
        this.mes = 1;
        this.ano = 1970;
    }

    public Data(int dia, int mes, int ano) {
        if (verificarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("data invalida");
        }
    }

    public Data(Data date) {
        if (verificarData(date.dia, date.mes, date.ano)) {
            this.dia = date.dia;
            this.mes = date.mes;
            this.ano = date.ano;
        } else {
            System.out.println("data invalida");
        }
    }

    public boolean isPrevious(Data outraData) {
        if (this.ano < outraData.ano) {
            return true;
        } else if (this.ano > outraData.ano) {
            return false;
        } else { // anos iguais
            if (this.mes < outraData.mes) {
                return true;
            } else if (this.mes > outraData.mes) {
                return false;
            } else { // meses iguais
                if (this.dia < outraData.dia) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean verificarData(int dia, int mes, int ano) {
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

    public int howManyDays(Data outraData) {
        int days = 0;
        if (isPrevious(outraData)) {
            Data dataAnterior = new Data(dia, mes, ano);
            while (dataAnterior.isPrevious(outraData)) {
                dataAnterior = dataAnterior.getNextDay();
                days++;
            }
        } else {
            Data dataAnterior = new Data(outraData);
            while (dataAnterior.isPrevious(this)) {
                dataAnterior = dataAnterior.getNextDay();
                days++;
            }
        }
        return days;
    }

    public int howManyDays(int dia, int mes, int ano) {
        int days = 0;
        if (verificarData(dia, mes, ano) == false) {
            return 0;
        }
        if (ano > this.ano) {
            while (ano > this.ano) {
                days += 360;
                --ano;
            }
        } else {
            while (ano < this.ano) {
                days += 360;
                ++ano;
            }
        }
        if (mes < this.mes) {
            while (mes < this.mes) {
                days -= getMaxDayOfMonth(mes);
                ++mes;
            }
        } else {
            while (mes > this.mes) {
                days += getMaxDayOfMonth(mes);
                --mes;
            }
        }
        if (dia < this.dia) {
            while (dia < this.dia) {
                ++days;
            }
        } else {
            while (dia > this.dia) {
                --days;
            }
        }
        return days;
    }

    private boolean isLeapYear() {
        return ((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0);
    }

    private int getMaxDayOfMonth(int mes) {
        int maxDay = 31;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            maxDay = 30;
        } else if (mes == 2) {
            if (isLeapYear()) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        }
        return maxDay;
    }

    private Data getNextDay() {
        int maxDay = getMaxDayOfMonth(mes);
        if (dia < maxDay) {
            return new Data(dia + 1, mes, ano);
        } else {
            if (mes < 12) {
                return new Data(1, mes + 1, ano);
            } else {
                return new Data(1, 1, ano + 1);
            }
        }
    }

    public String dayOfWeek() {
        int q = dia;
        int m = mes;
        int y = ano;

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;

        int h = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        return diasDaSemana[h];
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

    public String imprimirData() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    public String imprimirDataExtenso() {
        return this.dia + " de " + meses[this.mes] + " de " + this.ano;
    }

    public void setData(Data novaData) {
        if (verificarData(novaData.dia, novaData.mes, novaData.ano)) {
            this.dia = novaData.dia;
            this.mes = novaData.mes;
            this.ano = novaData.ano;
        } else {
            System.out.println("data invalida");
        }
    }

    public void setData(int dia, int mes, int ano) {
        if (verificarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("data invalida");
        }
    }

    // nao podem ser implementadas conforme o cabeçalho do slide pois ja tem um
    // metodo que usa um int no argumento
    // public void setData(int daquiXdias, int a)
    // public void setData(int primeiraSegundaFeiraDoMesX)

    public void setData(int primeiroDiaDoMesX) {
        if (primeiroDiaDoMesX > 0 && primeiroDiaDoMesX < 13) {
            this.dia = 1;
            this.mes = primeiroDiaDoMesX;
        }
    }

    public static Data getDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        int dia = dataAtual.getDayOfMonth();
        int mes = dataAtual.getMonthValue();
        int ano = dataAtual.getYear();

        return new Data(dia, mes, ano);
    }

    public static int howManyDaysUntilEndYear(Data d) {
        Data data = new Data(d);
        int days = 0;
        while (true){
            if (data.getMes() < 13){
                data.setMes(1);
                break;
            }
            days += howManyDaysUntilNextMonth(data);
            data.setMes(data.getMes() + 1);
        }
        return days;
    }

    public static int howManyDaysUntilNextMonth(Data d) {
        Data data = new Data(d);
        int days = 0;
        if (data.getMes() == 2){
            if (isBisexto(d)){
                if (data.getDia() == 29){
                    return days;
                }
                days += 29 - data.getDia();
            } else {
                if (data.getDia() == 28){
                    return days;
                }
                days += 28 - data.getDia();
            }
        }
        if (data.getMes() == 1 && data.getMes() == 3 && data.getMes() == 5 && data.getMes() == 7 && data.getMes() == 8 && data.getMes() == 10 && data.getMes() == 12){
            days += 31 - data.getDia();
        } else {
            days += 30 - data.getDia();
        }
        return days;
    }

    public static boolean isBisexto(Data d){
        Data data = new Data(d);
        if ((data.getAno() % 4 == 0 && data.getAno() % 100 != 0) || data.getAno() % 400 == 0) {
            return true;
        }
        return false;
    }

    public static String dayOfWeek(Data d){
        int q = d.getDia();
        int m = d.getMes();
        int y = d.getAno();

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;

        int h = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        return diasDaSemana[h];
    }

    public static String dayToPrintShort(Data d){
        return d.getDia() + "/" + d.getMes() + "/" + d.getAno();
    }

    public static String dayToPrintLong(Data d){
        return d.getDia() + " de " + meses[d.getMes()] + " de " + d.getAno();
    }
}
