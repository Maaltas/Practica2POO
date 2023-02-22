package Sessio3;

public class Main {
    public static void main (String [] args){
        SenyalTransit [] senyals = new SenyalTransit[20];
        Ubicacio u = new Ubicacio(30,"Gracia",78);
        Ubicacio u1 = new Ubicacio(40,"Bcn",89);
        int numReg=0, numAdv=0, numInd=0;
        for (int i = 0, cont=1; i<senyals.length; i++){
            switch (cont){
                case 1:{
                    senyals[i]=new Reglamentacio(GenerarParametresSenyal.generarCodi(0),u,GenerarParametresSenyal.generarAny(2023),"Indica reglamentacio");
                    cont++;
                    break;
                }
                case 2:{
                    senyals[i]=new Advertencia(GenerarParametresSenyal.generarCodi(1),u,GenerarParametresSenyal.generarAny(2023),"Indica advertencia");
                    cont++;
                    break;
                }
                case 3:{
                    senyals[i]=new Indicacio(GenerarParametresSenyal.generarCodi(2),u,GenerarParametresSenyal.generarAny(2023),"Indica indicacio");
                    cont++;
                    break;
                }
                case 4:{
                    senyals[i]=new Indicacio(32,32,GenerarParametresSenyal.generarCodi(3),u,GenerarParametresSenyal.generarAny(2023),"Indica indicacio");
                    cont=0;
                    break;
                }
            }
        }
        for (int j=0; j< senyals.length;j++){
            if (senyals[j] instanceof Reglamentacio){
                numReg++;
            } else if (senyals[j] instanceof Advertencia){
                numAdv++;
            } else if (senyals[j] instanceof Indicacio){
                numInd++;
            }
        }
        System.out.println(senyals[1].toString());
        System.out.println(senyals[2].toString());
        System.out.println(senyals[3].toString());
        System.out.println("Numero de reglamentacio: " + numReg + " numero de advertencia: " + numAdv + " numero de indicacio: " + numInd);
    }


}
