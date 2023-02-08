package Sessio1Practica2;

import java.util.Objects;

class Ubicacio {
    private int numCarrer;
    private String nomCarrer;
    private SenyalTransit [] senyals;
    private int numSenyals;
    private int maxSenyals;

    Ubicacio(int Maxim, String carrer, int numero){
        maxSenyals=Maxim;
        nomCarrer=carrer;
        numCarrer=numero;
        senyals = new SenyalTransit[maxSenyals];
        numSenyals=0;
    }
    String getNomCarrer(){
        return nomCarrer;
    }
    int getNumCarrer(){
        return numCarrer;
    }
    int getNumSenyals(){
        return numSenyals;
    }
    boolean iguals (Ubicacio u){
        return u.getNomCarrer().equals(this.getNomCarrer()) && u.numCarrer == this.numCarrer;
    }
    SenyalTransit getSenyal(int quin){
        if (quin>numSenyals){
            return null;
        } else {
            return this.senyals[quin];
        }
    }
    boolean afegirSenyal (SenyalTransit c){
        if (maxSenyals==numSenyals){
            return false;
        } else {
            for (int x=0; x<maxSenyals; x++){
                if (senyals[x].equals(c)){
                    return false;
                } else {
                    if (senyals[x]==null){
                        senyals[x]=c;
                        numSenyals++;
                    }
                }
            }
        }
        return false;
    }
    boolean treureSenyal (SenyalTransit c) {
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
    String getSenyals(){
        String s = "";
        for (int x=0; x<numSenyals; x++){
            if(x==0 || x==numSenyals-1){
                s=this.getNomCarrer();
            } else {
                s=s.concat(senyals[x].getCodi()) + " - ";
            }
                  
        }
        return s;
    }
}

