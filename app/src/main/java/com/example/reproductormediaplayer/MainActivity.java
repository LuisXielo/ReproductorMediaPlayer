package com.example.reproductormediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 1, posicion = 0;

    MediaPlayer vectormp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button) findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        iv = (ImageView) findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);
    }

    // metodo play y pause

    public void PlayPause(View view) {

        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();

        } else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo stop
    public void Stop(View view) {
        // "int p_actual = posicion;" poner esto para abajo no poner posicion = 0

        if (vectormp[posicion] != null) {
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.race);
            vectormp[1] = MediaPlayer.create(this, R.raw.sound);
            vectormp[2] = MediaPlayer.create(this, R.raw.tea);
            // se puede poner posicion = p_actual;;
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    public void Repetir(View view) {

        if (repetir == 1) {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "no repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    // metodo siguiente
    public void Siguiente(View view) {
        // posicion 0,1,2 pero indice 1,2,3.para que se iguale restamos uno a indices ( vectormp )
        if (posicion < vectormp.length - 1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.race);
                vectormp[1] = MediaPlayer.create(this, R.raw.sound);
                vectormp[2] = MediaPlayer.create(this, R.raw.tea);
                posicion++;
                vectormp[posicion].start();

                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3);
                }

            } else {
                posicion++;

                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }

    // metodo regresar
    public void Regresar(View view) {
        if (posicion >= 1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.race);
                vectormp[1] = MediaPlayer.create(this, R.raw.sound);
                vectormp[2] = MediaPlayer.create(this, R.raw.tea);
                posicion--;
                vectormp[posicion].start();

                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3);
                }

            } else {
                posicion--;

                if (posicion == 0) {
                    iv.setImageResource(R.drawable.portada1);
                } else if (posicion == 1) {
                    iv.setImageResource(R.drawable.portada2);
                } else if (posicion == 2) {
                    iv.setImageResource(R.drawable.portada3);
                }
            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();
        }

    }
}