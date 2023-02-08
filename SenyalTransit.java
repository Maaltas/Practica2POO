package Sessio1Practica2;

class SenyalTransit {
    private String tipus;
    private String codi;
    private Ubicacio u;

    String getTipusSenyal(){
        return tipus;
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
