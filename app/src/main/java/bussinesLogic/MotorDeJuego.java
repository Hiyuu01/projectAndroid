package bussinesLogic;

import com.example.osmany.ahorcado.R;

/**
 * Created by Osmany on 21/01/2018.
 */

public class MotorDeJuego {
    int contadorImagen;

    public MotorDeJuego() {
        contadorImagen=0;
    }

    public int getContadorImagen() {
        return contadorImagen;
    }


    public int dameImagen(){

        if(contadorImagen==0){
            contadorImagen++;
            return R.drawable.iniciohorca;
        }else if (contadorImagen==1){
            contadorImagen++;
            return R.drawable.horcacabeza;
        }else if(contadorImagen==2){
            contadorImagen ++;
            return R.drawable.horcacuerpo;
        }else if(contadorImagen==3){
            contadorImagen++;
            return R.drawable.horcabrazod;
        }else if(contadorImagen==4){
            contadorImagen++;
            return R.drawable.horcabrazoi;
        }else if(contadorImagen==5){
            contadorImagen ++;
            return R.drawable.horcapiernad;
        }else if(contadorImagen==6){
            contadorImagen ++;
            return R.drawable.horcapiernai;
        }
        return 7;

    }
}
