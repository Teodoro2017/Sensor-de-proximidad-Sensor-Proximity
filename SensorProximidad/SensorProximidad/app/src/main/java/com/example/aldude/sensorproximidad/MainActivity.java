package com.example.aldude.sensorproximidad;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;


         //"public class MainActivity extends AppCompatActivity" es la línea de texto que sale por defecto al crear el proyecto
        //nosotros le agregamos a esa línea "implements SensorEventLstener" (Como se muestra a continuación)
        // Al principio nos marcará error, pero al pasar el puntero sobre la línea subrayada e ir al "foquito"
         //Le damos a "Implement Methods", nos abrirá una nueva ventana en la cual nos saldrá dos métodos que debemos agregar, le damos "Ok" y se solucionará
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //Declaramos
    RelativeLayout relat;
    //El SensorManager se utiliza para administrar los sensores en general
    SensorManager sm;
    Sensor sensor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Declarmaos métodos que se escribieron al inicio
        relat = (RelativeLayout)findViewById(R.id.relative);
        tv = (TextView)findViewById(R.id.texto);

        //Declaramos el SensorManager utilizamos el ".getSystemService" para declarar que usaremos un servicio
        //Y el "SENSOR_SERVICE" aclara que usaremos un servicio del tipo sensor
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Declaramos el Sensor, en esta línea se programa que el sensor que usarmeos es el sensor de Proximidad ""
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    //Cambiará sus valores, nos dirá y nos daremos cuenta de que el sensor ha cambiado
    public void onSensorChanged(SensorEvent event) {

        //Declaramos una cadena donde ordenamos que el texto nos cambe el valor
        //Con la línea event.values[0] nos da un valor por defecto
        //Y con la cadena hacemos que ese valor se muestre en texto
        String texto = String.valueOf(event.values[0]);
        tv.setText(texto);

        //Volvemos un valor a la varable texto
        float valor = Float.parseFloat(texto);

        //Validamos la varable valor
        if (valor == 0 ){

            //Esta línea declara que el color azul sea el inicial
            relat.setBackgroundColor(Color.BLUE);
        }else {

            //Esta línea declara que al pasar la mano sobre el sensor cambiará al color amarillo
            relat.setBackgroundColor(Color.YELLOW);
        }
    }

    //Por el momento no usaremos esta línea ya que se emplea para otro tipo de ejercicios
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
