package biblioteca;

import java.util.ArrayList;

import bussinesLogic.Palabras;

/**
 * Created by Osmany on 21/01/2018.
 */

public class Biblioteca {


    ArrayList<Palabras> listaPalabras;

    Palabras palabra1 = new Palabras("fiesta",true,"https://s3.amazonaws.com/fancyfootageclips/website/vid/2015-02-02-concert.mp4");
    Palabras palabra2 = new Palabras("coche",false,"lo usasamos para desplazarnos");

    public Biblioteca(){
        listaPalabras = new ArrayList<>();
        listaPalabras.add(palabra1);
        listaPalabras.add(palabra2);
    }

    public Palabras damePalabra(){
        int posicionPalabra = (int) (Math.random()*listaPalabras.size());
        Palabras p = listaPalabras.get(posicionPalabra);
        listaPalabras.remove(posicionPalabra);
        return p;
    }

}
