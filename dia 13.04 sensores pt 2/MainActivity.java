package com.example.sensoresn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button proximo, listar;
    private TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (sensorManager) getSystemService(SENSOR_SERVICE);
        listar = findViewById(R.id.listar);
        proximo = findViewById(R.id.proximo);
        resposta = findViewById(R.id.resposta);


        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recebe = "";
                List<Sensor> listagem = sensorManager.getSensorList(Sensor.TYPE_ALL);
                for(int i=0; i<listagem.size(i);i++)
                {
                    recebe += listagem.get(i).getName() + "\n";
                }
                resposta.setText(" "+ recebe);
            }
        });

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJanela();
            }
        });

    }
    public void abrirJanela(){
        Intent janela = new Intent(this, SensorProximidade.class);
        startActivity(janela);
    }

}