package br.edu.fecap.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Bloco onde o usuario escolhe uma opção (pedra, papel, tesoura)
    public  void selecPedra(View view){
        this.opcaoSelec("pedra");
    }

    public  void selecPapel(View view){
        this.opcaoSelec("Papel");

    }

    public  void selecTesoura(View view){
        this.opcaoSelec("Tesoura");

    }

    // Bloco de escolha do App (PC) e mudança da figura:
    public  void opcaoSelec(String opcaoSelec){
        // Vincula o elemento ImageView ao programa:
        ImageView imgResultado = findViewById(R.id.imageBasse);
        TextView textoResultado = findViewById(R.id.textResultado);

        // Logica do App que seleciona de forma Randomica uma opçãp

        int numero = new Random().nextInt( 3);
        String [] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        // Faz a apres. Switch da imagem que o App selecioanr.

        switch (opcaoApp){
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                    imgResultado.setImageResource(R.drawable.papel);
                    break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        // Resultado - App Ganhou:
        if (
                        (opcaoApp == "Tesoura"  && opcaoSelec == "papel" ) ||
                        (opcaoApp == "papel" && opcaoSelec =="pedra") ||
                        (opcaoApp == "pedra" && opcaoSelec == "tesoura")
        ){ // App Ganhou
            textoResultado.setText("Você perdeu Mané...");
        } else if (
                        (opcaoSelec == "Tesoura"  && opcaoApp == "papel" ) ||
                        (opcaoSelec  == "papel" && opcaoApp =="pedra") ||
                        (opcaoSelec  == "pedra" && opcaoApp == "tesoura")
        ){// Player Vencer
            textoResultado.setText("Você ganmho... quer um Biscoito!!");
        } else {// Empate
            textoResultado.setText("Empatou... Mas não ganhou");
        }

    }

}