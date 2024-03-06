package br.edu.fecap.projetoaulainteface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view){
        TextInputEditText campoPO = findViewById(R.id.InputPO);
        TextInputEditText campoPI = findViewById(R.id.InputPI);
        TextInputEditText campoNI = findViewById(R.id.InputNI);
        TextView textoResultado = findViewById(R.id.TextResultado);

        // Cria o objeto nome, recupera(get) o texto e converte para String:
        String PO = campoPO.getText().toString();
        String PI = campoPI.getText().toString();
        String NI = campoNI.getText().toString();

        // Convertendo de String(texto) para Número:

        double NotaPO = Double.valueOf(PO).doubleValue();
        double NotaPI = Double.valueOf(PI).doubleValue();
        double NotaNI = Double.valueOf(NI).doubleValue();

        // Exibe no campo Resultado o nome digitado:
        textoResultado.setText(" Com a nota na PO sendo: "+ PO + ", na PI " + PI + "e na sua NI " + NI +" , sua nota final foi: "
                +NotaFinal(NotaPO, NotaPI, NotaNI));
    }

    public double NotaFinal(double campoPO, double campoPI, double campoNI){

        double NotaFinal = (campoPO * 0.5) + (campoPI * 0.3) + (campoNI * 0.2) ;
        return NotaFinal;
    }
}