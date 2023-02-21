package Sessio3;

public class Advertencia extends SenyalTransit {
    private String significatSenyal;
    private float costat;

    public String getSignificatSenyal(){
        return significatSenyal;
    }
    public float getCostat(){
        return costat;
    }
    public Advertencia (String codi, Ubicacio u, int anyColocacio, String significatSenyal){
        super(codi,u,anyColocacio);
        costat=70;
    }

    public Advertencia(int costat, String codi, Ubicacio u, int anyColocacio, String significatSenyal){
        this(codi,u,anyColocacio,significatSenyal);
        this.costat=costat;
    }

    public float area() {
        return (costat*costat)/2;
    }

    public String toString(){
        return getSignificatSenyal() + super.toString() + " de costat: " + getCostat();
    }
}
