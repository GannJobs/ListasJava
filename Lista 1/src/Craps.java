package src;
import java.util.Random;

class Craps {  
  public static void main0(String[] args) {
    Random rand = new Random();
    int dado1, dado2;
    boolean end = false;
    //estágio 1
    dado1 = rand.nextInt(5) + 1;
    dado2 = rand.nextInt(5) + 1;
    System.out.println("Dado 1: "+dado1+", Dado 2:"+dado2);
    int ponto = dado1 + dado2;
    System.out.println("Ponto: "+ponto);
    if (ponto == 11 || ponto == 7){
      System.out.println("Você Venceu, que Sortudo!!!");
      end = true;
    }
    if (ponto == 2 || ponto == 3 || ponto == 12){
      System.out.println("Você Perdeu que azar...");
      end = true;
    }
    //estagio 2
    System.out.println("Iniciado estágio 2");
    int a = 1;
    while(end == false){
      dado1 = rand.nextInt(5) + 1;
      dado2 = rand.nextInt(5) + 1;
      System.out.println("Dado 1: "+dado1+", Dado 2:"+dado2);
      System.out.println("Jogada "+a+": "+ (dado1 + dado2));
      if (ponto == dado1 + dado2){
        System.out.println("Você Venceu, que Sortudo!!!");
        end = true;
      }
      if (7 == dado1 + dado2){
        System.out.println("Você Perdeu que azar...");
        end = true;
      }
      a++;
    }
  }
}