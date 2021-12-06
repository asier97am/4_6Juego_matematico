package com.asier.aranda.a4_6juego_matematico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    public Switch switchYellow;
    public LinearLayout layout;
    public ToggleButton toggleButton;
    public RadioButton rbsi,rbno;
    public Button btcomprobar,btAleatorio;
    public TextView tvAlea,tvComprobacion;

    public boolean esBisiesto;
    public int aleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rbsi   = (RadioButton) findViewById(R.id.rbsi);
        rbno   = (RadioButton) findViewById(R.id.rbno);

        btcomprobar =(Button) findViewById(R.id.btcomprobar);
        btAleatorio =(Button) findViewById(R.id.btAleatorio);

        tvAlea =(TextView) findViewById(R.id.tvAlea);
        tvComprobacion =(TextView) findViewById(R.id.tvComprobacion);


        switchYellow  =findViewById(R.id.switchYellow);
        layout = findViewById(R.id.layout);
        toggleButton=findViewById(R.id.toggleButton);

    }
//    Toast
//    Toast.makeText(this, "OPERACION NO VALIDA", Toast.LENGTH_LONG).show();

    //Boton que genera un numero aleatorio y lo envia  a TextView(tvAlea)
    public void btAleatorio(View view) {
        int min=1900;
        int max=2500;
        aleatorio = (int) (Math.random() *(max+1-min)+min);
        tvAlea.setText(""+aleatorio);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
               // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbsi:
                if (rbsi.isChecked())
                    esBisiesto = true;
                break;
            case R.id.rbno:
                if (rbno.isChecked())
                    esBisiesto = false;
                break;
        }

    }

//  Comprobamos que el numero de TEXTVIEW(tvAlea) es bisiesto o no
    public void btcomprobar(View view) {


        //almaceno en variable INT aleatorio el valor de tvAlea que es donde ya sacamos el valor Aleatorio
        int aleatorio = Integer.parseInt(String.valueOf(tvAlea.getText()));
        //Con esta variable comprobaremos si es aleatorio o no
        boolean correcto;

        //Comprobamos si es aleatorio y lo almacenamos en "CORRECTO"
        if ((aleatorio % 4 == 0) && ((aleatorio % 100 != 0) || (aleatorio % 400 == 0)))
             correcto=true;
        else
            correcto = false;

        if(tvAlea.getText().equals("0")){
            Toast.makeText(this, "Debe GENERAR UN NUMERO ALEATORIO antes", Toast.LENGTH_SHORT).show();
        }else{
            //IF radio "SI" esta checked haz lo siguiente
            if(rbsi.isChecked()){
                //if Aleatorio es TRUE(es bisiesto) imprime acerte era bisiesto
                if(correcto==true){
                    tvComprobacion.setText("Muy bien, Acertaste que el número: " + aleatorio + " era BISIESTO");
                    tvComprobacion.setTextColor(Color.GREEN);
                }
                //if Aleatorio es FALSE(NO es bisiesto) imprime MAL era bisiesto
                else{
                    tvComprobacion.setText("MAL, el número: " + aleatorio + " NO ES BISIESTO ");
                    tvComprobacion.setTextColor(Color.RED);
                }
            }
            //IF radio "NO" esta checked haz lo siguiente
            else if(rbno.isChecked()){
                //if Aleatorio es FALSE(NO es bisiesto) imprime ACERTE  NO era bisiesto
                if(correcto==false){
                    tvComprobacion.setText("Muy bien, Acertaste que el número: " + aleatorio + " NO era BISIESTO");
                    tvComprobacion.setTextColor(Color.GREEN);
                }
                //if Aleatorio es TRUE(SI es bisiesto) imprime MAL  SI era bisiesto
                else{
                    tvComprobacion.setText("MAL, el número: " + aleatorio + " SI ES BISIESTO ");
                    tvComprobacion.setTextColor(Color.RED);
                }
            }
            //si ningun radio button esta checcked muestra el toast
            else if(!rbsi.isChecked() && !rbno.isChecked()){
                Toast.makeText(this, "Debe escoger una de las opciones", Toast.LENGTH_SHORT).show();
            }
        }



    }

    //SWITCH
    public void switchYellow(View view){
        if(switchYellow.isChecked()) {
            layout.setBackgroundColor(Color.YELLOW);
        }
        else {
            layout.setBackgroundColor(Color.WHITE);
        }

    }
    //Toggle cambia color
    public void toggleButton(View view){
        if(toggleButton.getText().equals("ON")) {
            layout.setBackgroundColor(Color.BLUE);
        }
        else {
            layout.setBackgroundColor(Color.WHITE);
        }
    }




}