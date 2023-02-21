package Sessio3;
import java.util.GregorianCalendar;

public abstract class SenyalTransit {
    // senyals circulars 50cm
    // senyals triangulars 70cm
    // senyals rectangulars 132 x 93cm
    private int tipus;
    private String codi;

    private Ubicacio ubicacio;
    private int anyUbicacio;
    private int anyRetirada;

    protected int numAdvertencia;
    protected int numReglamentacio;
    protected int numIndicacio;

    public static final int Quadrada = 1;
    public static final int Rectangular = 2;
    public static final int Triangular = 3;
    public static final int Rodona = 4;
    public SenyalTransit (String codi, Ubicacio ubicacio,int anyColocacio){
        this.codi=codi;
        inicialitzarSenyal(this.codi);
        if(!ubicacio.afegirSenyal(this)){
            this.ubicacio=null;
            this.anyRetirada=anyColocacio;
        } else {
            this.ubicacio=ubicacio;
            this.anyUbicacio=anyColocacio;
        }
    }
    public SenyalTransit (Ubicacio u){
        this(GenerarParametresSenyal.generarCodi(),u,GenerarParametresSenyal.generarAny(2023));
    }
    public SenyalTransit (int anyColocacio, Ubicacio u){
        this(GenerarParametresSenyal.generarCodi(),u,anyColocacio);
    }
    private void inicialitzarSenyal(String s){
        String[] parts = s.split("-");
        switch (parts[1]) {
            case "QUA" -> tipus = Quadrada;
            case "REC" -> tipus = Rectangular;
            case "TRI" -> tipus = Triangular;
            case "ROD" -> tipus = Rodona;
        }
    }
    public int getNumAdvertencia(){
        return numAdvertencia;
    }
    public int getNumReglamentacio(){
        return numReglamentacio;
    }
    public int getNumIndicacio(){
        return numIndicacio;
    }
    public String getCodi(){
        return codi;
    }
    public String getEstat() {
        int num = 2023 - this.anyUbicacio;
        if (num > 4) {
            return "vell";
        } else if (num >= 2) {
            return "semi nou";
        } else
            return "nou";
    }
    public boolean retirarViaPublica (int anyRetirada){
        if (anyUbicacio==anyRetirada){
            return retirarViaPublica();
        }
        return false;
    }
    public boolean retirarViaPublica(){
        if(!ubicacio.treureSenyal(this)){
            return false;
        } else {
            GregorianCalendar avui = new GregorianCalendar();
            ubicacio=null;
            anyUbicacio=0;
            anyRetirada=avui.get(1);
            return true;
        }
    }
    public boolean canviarUbicacio(Ubicacio ubicacioNova){
        if(!ubicacioNova.afegirSenyal(this)){
            return false;
        } else {
            if(ubicacioNova.treureSenyal(this)){
                ubicacio=ubicacioNova;
                return true;
            } else {
                return false;
            }
        }
    }
    public String toString(){
        String tipus=" ";
        if ((this instanceof Advertencia)) {
            tipus = "Advertenica";
        } else if ((this instanceof Reglamentacio)) {
            tipus = "Reglamentacio";
        } else if ((this instanceof Indicacio)) {
            tipus = "Indicacio";
        }
        if (anyUbicacio>0){
            return "Senyal de tipus: " + tipus + ", amb codi: " + codi + ", que es va colocar l'any: " + anyUbicacio;
        } else {
            return "Senyal de tipus: " + tipus + ", amb codi: " + codi + ", que es va retirar l'any: " + anyRetirada;
        }
    }
    public abstract float area();


}
