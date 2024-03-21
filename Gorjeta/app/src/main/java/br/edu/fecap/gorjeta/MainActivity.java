package br.edu.fecap.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textoPorcentagem, textoGorjeta, textoTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textoPorcentagem = findViewById(R.id.textoPorcentagem);
        textoGorjeta = findViewById(R.id.testoGorjeta);
        textoTotal = findViewById(R.id.textoTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textoPorcentagem.setText(Math.round(porcentagem) +"%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")){

        }
        else {
            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorjeta = Math.round(valorDigitado * (porcentagem / 100));
            double  total = Math.round(gorjeta + valorDigitado);

            textoGorjeta.setText("R$ "+gorjeta);
            textoTotal.setText("R$ "+total);
        }
    }
}