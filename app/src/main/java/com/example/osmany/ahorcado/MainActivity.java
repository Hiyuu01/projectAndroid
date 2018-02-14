package com.example.osmany.ahorcado;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import biblioteca.Biblioteca;
import bussinesLogic.MotorDeJuego;
import bussinesLogic.Palabras;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener{
    MediaPlayer mediaPlayer;
    VideoView videoView;
    TableLayout table;
    Reproductor reproductor;
    TextView vPalabra;
    TextView vidas;
    TextView money;
    Button ayuda;
    Button pararVideo;
    Button nuevaPartida;
    Biblioteca biblioteca;
    Palabras palabra;
    MotorDeJuego motorDeJuego;
    int contadorSonido;
    int contadorHorca;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] letras = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Ñ","Z","X","C","V","B","N","M"};
        videoView = findViewById(R.id.video_view);
        pararVideo= findViewById(R.id.btn_stop);
        pararVideo.setOnClickListener(this);
        vidas=findViewById(R.id.vidas);
        money = findViewById(R.id.money);
        table = findViewById(R.id.table_layout);
        reproductor = new Reproductor(this,videoView);
        ayuda = findViewById(R.id.btn_ayuda);
        ayuda.setOnClickListener(this);
        nuevaPartida= findViewById(R.id.btn_nueva_partida);
        nuevaPartida.setOnClickListener(this);
        vPalabra=findViewById(R.id.palabra);
        biblioteca=new Biblioteca();
        contadorSonido=0;
        contadorHorca=0;
        motorDeJuego = new MotorDeJuego();
        imageView = findViewById(R.id.img_horca);
        imageView.setImageResource(motorDeJuego.dameImagen());

        int j=0;
        for(int i =0;i<3;i++){
            TableRow tb = new TableRow(this);
            tb.setGravity(Gravity.CENTER_HORIZONTAL);
            for(int k=0;k<10;k++){
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.letras,null);
                tv.setId(j);
                tv.setText(letras[j]+" ");
                j++;
                tv.setGravity(Gravity.CENTER_HORIZONTAL);
                tb.addView(tv);
                if(j==27)break;
            }
            table.addView(tb);
        }
        Biblioteca biblioteca = new Biblioteca();

        palabra=biblioteca.damePalabra();

        vPalabra.setText(palabra.construirPalabra());
        palabra.separaPalabra();



    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_ayuda:
                if(palabra.isTieneVideo()) {
                    pararVideo.setVisibility(View.VISIBLE);
                    table.setVisibility(View.INVISIBLE);
                    ayuda.setVisibility(View.INVISIBLE);
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setVideoURI(Uri.parse(palabra.getPista()));
                    videoView.setOnPreparedListener(this);
                }
                    Toast.makeText(this,palabra.getPista(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_nueva_partida:
                Intent intent = new Intent();
                intent.setClass(this,this.getClass());
                this.startActivity(intent);
                this.finish();
                break;
            case R.id.btn_stop:
                videoView.stopPlayback();
                pararVideo.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
                ayuda.setVisibility(View.VISIBLE);
                videoView.setVisibility(View.INVISIBLE);


        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

        videoView.start();

    }

    public void comprobar(View view){
       TextView aux = (TextView) view;
       String letr = aux.getText().toString().trim().toLowerCase();

       if(palabra.comprobarLetra(letr)){
           reproductor.reproducirSonido(mediaPlayer,R.raw.yuju);
           contadorSonido=0;
           vPalabra.setText(palabra.reverlarLetra(letr));
           money.setText(String.valueOf(Integer.parseInt(money.getText().toString())+10));
           view.setVisibility(View.INVISIBLE);
           if(!vPalabra.getText().toString().contains("_")){
               imageView.setImageResource(R.drawable.bienhecho);
               ayuda.setVisibility(View.INVISIBLE);
               nuevaPartida.setVisibility(View.VISIBLE);
           }

       }else{
           if(motorDeJuego.getContadorImagen()!=7) {
               if (contadorSonido == 0) {
                   reproductor.reproducirSonido(mediaPlayer, R.raw.error);
                   contadorSonido = 1;
               } else {
                   reproductor.reproducirSonido(mediaPlayer, R.raw.feo);
               }
               if(Integer.parseInt(money.getText().toString())!=0){
                   money.setText(String.valueOf(Integer.parseInt(money.getText().toString())-5));
               }
               vidas.setText(String.valueOf(Integer.parseInt(vidas.getText().toString())-1));
               imageView.setImageResource(motorDeJuego.dameImagen());
               view.setVisibility(View.INVISIBLE);
                if(motorDeJuego.getContadorImagen()==7){
                    imageView.setImageResource(R.drawable.gameover);
                    ayuda.setVisibility(View.INVISIBLE);
                    nuevaPartida.setVisibility(View.VISIBLE);
                }
           }

        }


    }

}
