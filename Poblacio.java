package Sessio2;

public class Poblacio {
    // f0 = emagatzema de forma consecutiva les ubicacions amb noms de carrers amb intervals [‘a’,’h’];
    // f1 = emagatzema de forma consecutiva les ubicacions amb noms de carrers amb intervals [‘i’,’n’];
    // f2 = emagatzema de forma consecutiva les ubicacions amb noms de carrers amb intervals [‘o’,’z’];
    private String nom;
    private int numH;
    public Ubicacio [][] ubicacio;
    public int numAH;
    public int numIN;
    public int numOZ;
    private int maxUbicacions;

    public Poblacio(int maxim, String poblacio, int numHabitants){
        maxUbicacions=maxim;
        numH=numHabitants;
        nom=poblacio;
        numAH=0;
        numIN=0;
        numOZ=0;
        ubicacio = new Ubicacio[3][maxUbicacions];
    }
    public String getNom(){
        return nom;
    }
    public int getNumH(){
        return numH;
    }
    public int getNumAH(){
        return numAH;
    }
    public int getNumIN(){
        return numIN;
    }
    public int getNumOZ(){
        return numOZ;
    }
    public int getMaxUbicacions(){
        return maxUbicacions;
    }

    public boolean afegirUbiacio(Ubicacio c){
        char s=c.getNomCarrer().toUpperCase().charAt(0); // agafem el string i el passem tot a majuscules per estalviar-nos comparacions i agafem el primer caracter en majuscules
        int fila=comprovarCaracter(s);
        if(fila==0){
            if (recurregutMetodeAfegir(numAH,fila,c)){
                    return false; // la ubiacio ja esta registrada a la matriu
            } else {
                ubicacio[fila][numAH]=c;
                numAH++;
                return true; // ubicacio registrada amb exit
            }
        } else if(fila==1){
            if (recurregutMetodeAfegir(numAH,fila,c)){
                    return false; // la ubiacio ja esta registrada a la matriu
            } else {
                    ubicacio[fila][numIN]=c;
                    numIN++;
                    return true; // ubicacio registrada amb exit
            }
        } else if(fila==2){
            if (recurregutMetodeAfegir(numAH,fila,c)){
                    return false; // la ubiacio ja esta registrada a la matriu
            } else {
                    ubicacio[fila][numOZ]=c;
                    numOZ++;
                    return true; // ubicacio registrada amb exit
            }
        }
        return false; // no pasa mai
    }
    public boolean eliminarUbicacio(Ubicacio c){
        char s=c.getNomCarrer().toUpperCase().charAt(0); // agafem el string i el passem tot a majuscules per estalviar-nos comparacions i agafem el primer caracter en majuscules
        int fila=comprovarCaracter(s);
        int col=0;
        if(fila==0){
            col = recurregutMetodeEliminar(numAH,fila,c);
            if (col>0){
                ubicacio[fila][col]=null;
                ubicacio[fila][col]=ubicacio[fila][numAH];
                numAH--;
                return true; // la ubiacio ha sigut eliminada ab exit
            } else {
                return false; // la ubicacio  no esta a la matriu
            }

        } else if(fila==1){
            col = recurregutMetodeEliminar(numIN,fila,c);
            if (col>0){
                ubicacio[fila][col]=null;
                ubicacio[fila][col]=ubicacio[fila][numIN];
                numIN--;
                return true; // la ubiacio ha sigut eliminada ab exit
            } else {
                    return false; // la ubicacio  no esta a la matriu
            }

        } else if(fila==2){
            col = recurregutMetodeEliminar(numOZ,fila,c);
            if (col>0){
                ubicacio[fila][col]=null;
                ubicacio[fila][col]=ubicacio[fila][numOZ];
                numOZ--;
                return true; // la ubiacio ha sigut eliminada ab exit
            } else {
                return false; // la ubicacio  no esta a la matriu
            }
        }
        return false; // no pasa mai
    }
    public int quantes(){
        return recurregutMetodeQuantes(numAH,0)+recurregutMetodeQuantes(numIN,1)+recurregutMetodeQuantes(numOZ,2);
    }
    public int quantes (char quin){
        int fila = comprovarCaracter(Character.toUpperCase(quin));
        int length = saberLlargariaFila(fila);
        int total=0;
        for (int y=0; y<length; y++){
            if (ubicacio[fila][y].getNomCarrer().toUpperCase().charAt(0)==quin){
                total=total+ubicacio[fila][y].getNumSenyals();
            }
        }
        return 0;
    }
    public int quantes (char inici, char fi){
        String temp = String.valueOf(inici);
        int code = temp.charAt(0); int total=0;
        char c = ' ';
        if (code>=65 && code<=73){
            while (code>=65 && code<=73){
                c = (char)code;
                total = total+quantes(c);
                code++;
            }
            return total;
        } else if (code<78){
            while (code<=78){
                c = (char)code;
                total = total+quantes(c);
                code++;
            }
            return total;
        } else if (code<90){
            while (code<=90){
                c = (char)code;
                total = total+quantes(c);
                code++;
            }
            return total;
        }
        return 0;
    }
    private int comprovarCaracter(char s){ // metode que retorna la fila a la qual correspon el caracter introduit, nomes comprova caracters en majuscules pero ja ho te en compte la programacio
        if(s=='A' || s=='B' || s=='C' || s=='D' || s=='E' || s=='F' || s=='G' || s=='H'){
            return 0;
        } else if(s=='I' || s=='J' || s=='K' || s=='L' || s=='M' || s=='N'){
            return 1;
        } else if(s=='O' || s=='P' || s=='Q' || s=='R' || s=='S' || s=='T' || s=='U'|| s=='V' || s=='W' || s=='X' || s=='Y' || s=='Z'){
            return 2;
        }
        return -1;
    }
    private int saberLlargariaFila(int fila){ // metode que retorna la llargaria de la fila, es imprescindible abans d'invocar aquest metode invocar el metode comprovarCaracter
        return switch (fila){
            case 0 -> numAH;
            case 1 -> numIN;
            case 2 -> numOZ;
            default -> 0;
        };
    }
    private int recurregutMetodeQuantes(int length, int fila){ // metode que calcula cada fila quantes senyals té
        int total=0;
        for (int x=0; x<length; x++){
            total=total+ubicacio[fila][x].getNumSenyals();
        }
        return total;
    }
    private int recurregutMetodeEliminar (int length, int fila, Ubicacio c){
        for (int y=0;y<length;y++){
            if(c.iguals(ubicacio[fila][y])){
                return y; // retorna la fila on esta la matriu per a poder eliminarla
            }
        }
        return -1; // retorna -1 si la ubicacio no esta a la matriu
    }
    private boolean recurregutMetodeAfegir(int length, int fila, Ubicacio c){ // metode que fa el recurregut per una fila de la matriu
        for (int y=0;y<length;y++){
            if(c.iguals(ubicacio[fila][y])){
                return true; // ubicacio trobada
            }
        }
        return false; // no s'ha trobat la ubicacio a la matriu
    }
}


