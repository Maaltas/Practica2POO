package Sessio3;

public class Reglamentacio extends SenyalTransit{
    private String significatSenyal;
    private float diametre;

    public String getSignificatSenyal(){
        return significatSenyal;
    }
    public float getDiametreiametre(){
        return diametre;
    }
    public Reglamentacio (String codi, Ubicacio u, int anyColocacio, String significatSenyal){
        super(codi,u,anyColocacio);
        diametre=70;
    }

    public Reglamentacio(int costat, String codi, Ubicacio u, int anyColocacio, String significatSenyal){
        this(codi,u,anyColocacio,significatSenyal);
        this.diametre=diametre;
    }

    public float area() {
        float pi = (float) Math.PI;
        return pi * (diametre/2)*(diametre/2);
    }

    public String toString(){
        return getSignificatSenyal() + super.toString() + " de costat: " + getDiametreiametre();
    }
}
