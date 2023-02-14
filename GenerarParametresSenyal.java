package Sessio2;
import java.util.Random;

public class GenerarParametresSenyal {
    public static String generarCodi(){
        int cont=0;
        String s="";
        while (cont<4){
            s=s+generarDigit();
            cont++;
        }
        s=s+"-";
        s=s+generarForma();
        return s;
    }
    public static int generarAny(int maxim){
        int x=0;
        Random rnd = new Random();
        return x=rnd.nextInt(maxim-1980+1)+1980;
    }
    public static char generarDigit(){
        Random rnd = new Random();
        int num = rnd.nextInt(10);
        char c = (char) (num+'0');
        return c;
    }
    public static String generarForma(){
        String[] opcions = {"ROD", "TRI", "REC", "QUA"};
        Random rnd = new Random();
        int i = rnd.nextInt(opcions.length);
        String result = opcions[i];
        return result;
    }
}
