/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Paciente;

public class ficha extends Patient{
    //atributos de la clase
    private String codigoFicha;
    private String tipoEnfermedad;
    private String tipoColor;
    private int numFicha;
//    private enum EnumColor;
//    private static int numFicha;
    private static int fichasRoja;
    private static int fichasVerde;
    private static int fichasAmarilla;

    //constructores
   public ficha(){
   }
    
    public ficha(String tipoColor, String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
        this.tipoColor = tipoColor;
        if(this.numFicha==99){  //lleva el número consecutivo de la ficha
            this.numFicha = 0;
        }else{
            this.numFicha++;
        }
        this.codigoFicha = this.tipoEnfermedad+" - "+this.tipoColor+" - "+this.numFicha;
        if(this.tipoColor=="Verde"){   // lleva la contidad de las ficha de los colores
            this.fichasVerde++;                
        }else if(this.tipoColor=="Rojo"){
            this.fichasRoja++;
        }else{
            this.fichasAmarilla++;
        }
    }

    //métodos set y get

    public String getCodigoFicha() {
        return codigoFicha;
    }

    public void setCodigoFicha(String codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }

    public String getTipoColor() {
        return tipoColor;
    }

    public void setTipoColor(String tipoColor) {
        this.tipoColor = tipoColor;
    }

    public int getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(int numFicha) {
        this.numFicha = numFicha;
    }

    public static int getFichasRoja() {
        return fichasRoja;
    }

    public static void setFichasRoja(int fichasRoja) {
        ficha.fichasRoja = fichasRoja;
    }

    public static int getFichasVerde() {
        return fichasVerde;
    }

    public static void setFichasVerde(int fichasVerde) {
        ficha.fichasVerde = fichasVerde;
    }

    public static int getFichasAmarilla() {
        return fichasAmarilla;
    }

    public static void setFichasAmarilla(int fichasAmarilla) {
        ficha.fichasAmarilla = fichasAmarilla;
    }
  
   @Override
    public String toString() {
        return "ficha{" + "codigoFicha=" + codigoFicha + ", tipoEnfermedad=" + tipoEnfermedad + ", tipoColor=" + tipoColor + ", numFicha=" + numFicha + '}';
    }

    
    
}
