package bussinesLogic;

/**
 * Created by Osmany on 21/01/2018.
 */

public class Palabras {
    String nombre;
    boolean tieneVideo;
    String pista;
    String[] palabraSeparada;
    String[] palabraOculta;

    public String[] getPalabraOculta() {
        return palabraOculta;
    }

    public void setPalabraOculta(String[] palabraOculta) {
        this.palabraOculta = palabraOculta;
    }

    public Palabras(String nombre, boolean tieneVideo, String pista){
        palabraSeparada= new String[nombre.length()];
        palabraSeparada= new String[nombre.length()];
        this.nombre=nombre;
        this.tieneVideo=tieneVideo;
        this.pista=pista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTieneVideo() {
        return tieneVideo;
    }

    public void setTieneVideo(boolean tieneVideo) {
        this.tieneVideo = tieneVideo;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public String construirPalabra(){
        String result = "";
       palabraOculta =new String[nombre.length()];
        for (int i = 0; i <palabraOculta.length ; i++) {
            palabraOculta[i]="_";
            result += "_" + " ";
        }
        return result.trim();

    }

    public void separaPalabra(){

        for (int i = 0; i <nombre.length() ; i++) {
            palabraSeparada[i]=String.valueOf(nombre.charAt(i));
        }

    }

    public String[] getPalabraSeparada() {
        return palabraSeparada;
    }

    public void setPalabraSeparada(String[] palabraSeparada) {
        this.palabraSeparada = palabraSeparada;
    }

    public boolean comprobarLetra(String letra){

        if(nombre.contains(letra)){
            return true;
        }

        return false;
    }

    public String reverlarLetra(String letra){
        for (int i = 0; i < palabraSeparada.length; i++) {
            if(palabraSeparada[i].equals(letra)){
                palabraOculta[i]=letra;
            }
        }
        String result="";
        for (int i = 0; i < palabraOculta.length ; i++) {
            result+=palabraOculta[i]+" ";
        }

        return result.trim().toUpperCase();

    }


}
