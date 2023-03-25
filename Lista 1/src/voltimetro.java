package src;
import java.util.Scanner;
import java.lang.Math;

class voltimetro {  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double[] meds;
    meds = new double[10];
    double DPS = 0;
    double Smeds = 0;
    double DesvioPadrao = 0;
    for(int i = 0; i < 10; i++){
      System.out.println("Insira o valor da "+(i+1)+" medição");
      meds[i] = sc.nextDouble();
      Smeds += meds[i];
    }
    Smeds /= 10;
    //calculo do Desvio padrao
    double aux;
    for(int i = 0; i < 10;i++){
      aux = Math.pow(meds[i] - Smeds, 2);
      DPS += aux; 
      aux = 0;
    }
    DesvioPadrao = Math.sqrt(DPS / 10);
    if (DesvioPadrao > (Smeds*0.1)){
      System.out.println("O voltimetro esta com problemas");;
    }else{
      System.out.print("O voltimetro esta funcional!");
    }
    sc.close();
  }
}