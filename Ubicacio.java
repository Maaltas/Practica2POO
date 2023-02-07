package Sessio1Practica2;

import java.util.Objects;

public class Ubicacio {
    private int numCarrer;
    private String nomCarrer;
    private SenyalTransit [] senyals;
    private int numSenyals;
    private int maxSenyals;

    public Ubicacio(int Maxim, String carrer, int numero){
        maxSenyals=Maxim;
        nomCarrer=carrer;
        numCarrer=numero;
        senyals = new SenyalTransit[maxSenyals];
        numSenyals=0;
    }
    public String getNomCarrer(){
        return nomCarrer;
    }
    public int getNumCarrer(){
        return numCarrer;
    }
    public int getNumSenyals(){
        return numSenyals;
    }
    public boolean iguals (Ubicacio u){
        return u.getNomCarrer().equals(this.getNomCarrer()) && u.numCarrer == this.numCarrer;
    }

}
