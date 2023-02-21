package Sessio3;

public class Indicacio extends SenyalTransit {
    private String significatSenyal;
    private float costat1;
    public float costat2;

    public String getSignificatSenyal(){
        return significatSenyal;
    }
    public float getCostat1(){
        return costat1;
    }
    public float getCostat2(){
        return costat2;
    }
    public Indicacio (String codi, Ubicacio u, int anyColocacio, String significatSenyal){
        super(codi,u,anyColocacio);
        costat1=132;
        costat2=93;
    }

    public Indicacio(int costat1, int costat2, String codi, Ubicacio u, int anyColocacio, String significatSenyal){
        this(codi,u,anyColocacio,significatSenyal);
        this.costat1=costat1;
        this.costat2=costat2;
    }

    public float area() {
        return costat1*costat2;
    }

    public String toString(){
        return getSignificatSenyal() + super.toString() + " on un costat es de: " + getCostat1() + " i el altre es de: " + getCostat2();
    }
}
