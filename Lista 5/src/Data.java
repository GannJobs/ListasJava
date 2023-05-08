public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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

    public boolean verificarData(int dia,int mes,int ano) {
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
                days--;
            }
        } else {
            Data dataAnterior = new Data(outraData.dia, outraData.mes, outraData.ano);
            while (dataAnterior.isPrevious(this)) {
                dataAnterior = dataAnterior.getNextDay();
                days++;
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
    
        int h = (q + 13*(m+1)/5 + k + k/4 + j/4 + 5*j) % 7;
    
        String[] diasDaSemana = { "sábado", "domingo", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira" };
    
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

    public void imprimirData() {
        System.out.printf("%02d/%02d/%04d", dia, mes, ano);
    }

    public void imprimirDataExtenso() {
        String[] meses = { "janeiro", "fevereiro", "março", "abril", "maio", "junho",
                "julho", "agosto", "setembro", "outubro", "novembro", "dezembro" };
        System.out.printf("%02d de %s de %04d", dia, meses[mes - 1], ano);
    }
}
