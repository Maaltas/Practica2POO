package Sessio1Practica2;

class SenyalTransit {
    private int tipus;
    private String codi;
    private Ubicacio ubicacio;
    private int anyUbicacio;
    private int anyRetirada;
    static int Advertencia = 123;
    static int Reglamentacio = 345;
    static int Indicacio = 678;
    SenyalTransit (String codi, Ubicacio ubicacio,int anyColocacio){
        this.codi=codi;
        this.ubicacio=ubicacio;
        if(!this.ubicacio.afegirSenyal()){

        }
    }
    String getTipusSenyal(){
        if (tipus==Advertencia){
            return "Advertencia";
        } else if (tipus==Reglamentacio){
            return "Reglamentacio";
        } else if (tipus==Indicacio){
            return "Indicacio";
        }
        return null;
    }
    String getCodi(){
        switch (this.getTipusSenyal()) {
            case "Advertencia":
                return codi = "TRI";
            case "Reglamentacio":
                return codi = "ROD";
            case "Indicacio":
                if (this.getTipusSenyal().equals("IndicacioRectangular")) {
                    return codi = "REC";
                } else if (this.getTipusSenyal().equals("IndicacioQuadrada")) {
                    return codi = "QUA";
                }
                break;
        }
        return codi;
    }
}
