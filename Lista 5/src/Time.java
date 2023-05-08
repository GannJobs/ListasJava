public class Time {
    private int hora;
    private int min;
    private int seg;

    public Time (int hora, int min, int seg){
        this.hora = hora;
        this.min = min;
        this.seg = seg;
    }

    public boolean isAM(){
        if (this.hora < 12){
            return true;
        }
        return false;
    }

    public int cron(Time outraHora){
        int ha, ma, sa;
        if (outraHora.hora > this.hora && outraHora.min > this.min && outraHora.seg > this.seg){
            ha = outraHora.hora - this.hora;
            ma = outraHora.min - this.min;
            sa = outraHora.seg - this.seg;
            return ((ha/60)/60) + (ma/60) + sa;
        } else {
            ha = this.hora -  outraHora.hora;
            ma = this.min - outraHora.min;
            sa = this.seg - outraHora.seg;
            return ((ha/60)/60) + (ma/60) + sa;
        }
    }

    public void addSeconds(int secs){
        int aux = (secs/60)/60;
        this.hora = aux;
        this.min = aux/60;
        this.seg = aux;
    }

    private boolean validateTime(int hora, int min, int seg){
        return validateHour(hora) && 
               validateMinOrSec(min) && 
               validateMinOrSec(seg);
    }

    private boolean validateHour(int hora){
        if((hora>=0) && (hora<25))
            return true;
        else
            return false;
    }

    private boolean validateMinOrSec(int param){
        if((param>=0) && (param<61))
            return true;
        else
            return false;
    }

    public void setTime(int hora, int min, int seg){
        if (validateTime(hora, min, seg)) {
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }
        else{
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    public String getTime(){
        String res = this.hora + ":" + this.min + ":" + this.seg;
        return res;
    }

    public void prnTime(){
        System.out.println(getTime());
    }
}