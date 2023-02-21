package Sessio1Practica2;

import java.util.Objects;

public class Ubicacio {
    private int numCarrer;
    private String nomCarrer;
    private SenyalTransit [] senyals;
    private int numSenyals;
    private final int maxSenyals;

    public Ubicacio(int Maxim, String carrer, int numero){
        senyals = new SenyalTransit[Maxim];
        numSenyals=0;
        maxSenyals=Maxim;
        nomCarrer=carrer;
        numCarrer=numero;
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
    public SenyalTransit getSenyal(int quin){
        if (quin>numSenyals){
            return null;
        } else {
            return senyals[quin];
        }
    }
    public boolean afegirSenyal (SenyalTransit c){
        if (maxSenyals==numSenyals){
            return false;
        } else {
            for (int x=0; x<maxSenyals; x++){
                if(senyals[x]==null){
                    senyals[x]=c;
                    numSenyals++;
                    return true;
                } else if (senyals[x].getCodi().equals(c.getCodi())){
                    return false;
                }
            }
        }
        return false;
    }
    public boolean treureSenyal (SenyalTransit c) {
        for (int j = 0; j < numSenyals; j++) {
            if (senyals[j].equals(c)){
                senyals[j]=senyals[numSenyals-1];
                numSenyals--;
                senyals[numSenyals]=null;
                return true;
            }
        }
        return false;
    }
    public String getSenyals(){
        String s = "";
        for (int x=0; x<numSenyals; x++){
            if(x==numSenyals-1){
                s=s.concat(senyals[x].getCodi());
            } else {
                s=s.concat(senyals[x].getCodi()) + " - ";
            }
        }
        return s;
    }
}

