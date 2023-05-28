import java.time.LocalDateTime;

public class Time {
    private int hora;
    private int min;
    private int seg;

    public int getHora(){
        return this.hora;
    }

    public int getMin(){
        return this.min;
    }

    public int getSeg(){
        return this.seg;
    }

    public Time (){
        this.hora = 0;
        this.min = 0;
        this.seg = 0;
    }

    public Time (int HH){
        this.hora = HH;
        this.min = 0;
        this.seg = 0;
    }

    public Time (int HH, int MM){
        this.hora = HH;
        this.min = MM;
        this.seg = 0;
    }

    public Time (int HH, int MM, int SS){
        this.hora = HH;
        this.min = MM;
        this.seg = SS;
    }

    public Time (Time time){
        this.hora = time.hora;
        this.min = time.min;
        this.seg = time.seg;
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

    public void addSeconds(Time tempo){
        this.hora += tempo.hora;
        while(validateHour(this.hora))
            this.hora -= 24;
        this.min += tempo.min;
        while(validateMinOrSec(this.min))
            this.min -= 60;
        this.seg += tempo.seg;
        while(validateMinOrSec(this.seg))
            this.seg -= 60;
    }

    public void addSeconds(int hora, int min,int secs){
        // adiciona as horas
        this.hora += hora;
        if (min > 60)
            this.hora += min/60;
        if (secs > 3600)
            this.hora += secs/3600;
        while(validateHour(this.hora))
            this.hora -= 24;
        // adiciona os minutos
        this.min += min;
        if (secs > 60)
            this.min += secs/60;
        while(validateMinOrSec(this.min))
            this.min -= 60;
        // adiciona os segundos
        this.seg += secs;
        while(validateMinOrSec(this.seg))
            this.seg -= 60;
    }

    public void addSeconds(int min,int secs){
        if (min > 60)
            this.hora += min/60;
        if (secs > 3600)
            this.hora += secs/3600;
        while(validateHour(this.hora))
            this.hora -= 24;
        // adiciona os minutos
        this.min += min;
        if (secs > 60)
            this.min += secs/60;
        while(validateMinOrSec(this.min))
            this.min -= 60;
        // adiciona os segundos
        this.seg += secs;
        while(validateMinOrSec(this.seg))
            this.seg -= 60;
    }

    public void addSeconds(int secs){
        if (secs > 3600)
            this.hora += secs/3600;
        while(validateHour(this.hora))
            this.hora -= 24;
        // adiciona os minutos
        if (secs > 60)
            this.min += secs/60;
        while(validateMinOrSec(this.min))
            this.min -= 60;
        // adiciona os segundos
        this.seg += secs;
        while(validateMinOrSec(this.seg))
            this.seg -= 60;
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

    public static Time diffTime(Time t1, Time t2){
        Time diferenca = new Time();
        if (t1.hora > t2.hora){
            diferenca.hora = t1.hora - t2.hora;
        } else {
            diferenca.hora = t2.hora - t1.hora;
        }
        if (t1.min > t2.min){
            diferenca.min = t1.min - t2.min;
        } else {
            diferenca.min = t2.min - t1.min;
        }
        if (t1.seg > t2.seg){
            diferenca.seg = t1.seg - t2.seg;
        } else {
            diferenca.seg = t2.seg - t1.seg;
        }
        return diferenca;
    }

    public static Time diffTime(Time t1){
        LocalDateTime agora = LocalDateTime.now();
        int hora = agora.getHour();
        int minuto = agora.getMinute();
        int segundo = agora.getSecond();
        Time pc = new Time(hora, minuto, segundo);
        Time dif = new Time(diffTime(t1, pc));
        return dif;
    }
    
    public static boolean isAm(Time t1){
        if (t1.hora > 12){
            return false;
        }
        return true;
    }

    public static boolean isPm(Time t1){
        if (t1.hora < 12){
            return false;
        }
        return true;
    }
}