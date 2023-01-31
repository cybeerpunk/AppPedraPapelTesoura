package com.example.apppedrapapeltesoura;

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

    public void selecionadoPedra(View view){ // quando usamos evento de onClick preciso definir um parametro obrigatório do tio View

        this.opcaoSelecionada("pedra");

    }

    public void selecionadoPapel(View view){

        this.opcaoSelecionada("papel");

    }

    public void selecionadoTesoura(View view){

        this.opcaoSelecionada("tesoura");

    }

    public void opcaoSelecionada(String escolhaUsuario) { //pelo usuário

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[ numero ];

        switch (escolhaApp){

            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "tesoura" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){ //App ganhador
            textoResultado.setText("Você perdeu :(");

        } else if(

                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                        (escolhaUsuario == "tesoura" && escolhaApp == "pedra") ||
                        (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){ //usuário ganhador
            textoResultado.setText("Você ganhou :)");
        } else { //empate
            textoResultado.setText("Empatamos ;)");
        }

    }
}