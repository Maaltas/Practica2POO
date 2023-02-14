package Sessio1Practica2;

import java.util.GregorianCalendar;

public class SenyalTransit {
    private int tipus;
    private String codi;
    private Ubicacio ubicacio;
    private int anyUbicacio;
    private int anyRetirada;
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
    private void inicialitzarSenyal(String s){
        String[] parts = s.split("-");
        switch (parts[1]) {
            case "QUA" -> tipus = 1;
            case "REC" -> tipus = 2;
            case "TRI" -> tipus = 3;
            case "ROD" -> tipus = 4;
        }
    }
    public String getTipusSenyal(){
        return switch (tipus) {
            case 1 -> "Indicacio";
            case 2 -> "Indicacio";
            case 3 -> "Advertencia";
            case 4 -> "Reglamentacio";
            default -> null;
        };
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

}
