public class DataHora {
    private Data data;
    private Time hora;

    // COMPOSIÇÂO

    public DataHora(int dia, int mes, int ano, int hora, int min, int seg){
        this.data = new Data(dia, mes, ano);
        this.hora = new Time(hora, min, seg);
    }

    public String toString(){
        return "Data: " + data.imprimirDataExtenso() + "\nHora: " + hora.getTime();
    }

    public boolean isEqual(DataHora outra){
        if (this.data == outra.data && this.hora == outra.hora){
            return true;
        }
        return false;
    }

    public boolean isGreather(DataHora outra){
        if (this.data.getAno() < outra.data.getAno()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() < outra.data.getMes()){
            return true;
        } else 
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() < outra.data.getDia()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() < outra.hora.getHora()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() < outra.hora.getMin()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() == outra.hora.getMin() && this.hora.getSeg() < outra.hora.getSeg()){
            return true;
        }
        return false;
    }

    public boolean isLower(DataHora outra){
        if (this.data.getAno() > outra.data.getAno()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() > outra.data.getMes()){
            return true;
        } else 
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() > outra.data.getDia()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() > outra.hora.getHora()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() > outra.hora.getMin()){
            return true;
        } else
        if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() == outra.hora.getMin() && this.hora.getSeg() > outra.hora.getSeg()){
            return true;
        }
        return false;
    }

    // AGREGAÇÂO

    // public DataHora(Data data, Time time){
    //     this.data = data;
    //     this.hora = time;
    // }

    // public String toString(){
    //     return "Data: " + data.imprimirDataExtenso() + "\nHora: " + hora.getTime();
    // }

    // public boolean isEqual(DataHora outra){
    //     if (this.data == outra.data && this.hora == outra.hora){
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean isGreather(DataHora outra){
    //     if (this.data.getAno() < outra.data.getAno()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() < outra.data.getMes()){
    //         return true;
    //     } else 
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() < outra.data.getDia()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() < outra.hora.getHora()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() < outra.hora.getMin()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() == outra.hora.getMin() && this.hora.getSeg() < outra.hora.getSeg()){
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean isLower(DataHora outra){
    //     if (this.data.getAno() > outra.data.getAno()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() > outra.data.getMes()){
    //         return true;
    //     } else 
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() > outra.data.getDia()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() > outra.hora.getHora()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() > outra.hora.getMin()){
    //         return true;
    //     } else
    //     if (this.data.getAno() == outra.data.getAno() && this.data.getMes() == outra.data.getMes() && this.data.getDia() == outra.data.getDia() && this.hora.getHora() == outra.hora.getHora() && this.hora.getMin() == outra.hora.getMin() && this.hora.getSeg() > outra.hora.getSeg()){
    //         return true;
    //     }
    //     return false;
    // }

    // ASSOCIAÇÂO

    // public DataHora(Data data, Time time){
    //     this.data = data;
    //     this.hora = time;
    // }

    // public String toString(){
    //     return "Data: " + "\nHora: ";
    // }

    // public boolean isEqual(DataHora outra){
    //     if (this.data == outra.data && this.hora == outra.hora){
    //         return true;
    //     }
    //     return false;
    // }
}
