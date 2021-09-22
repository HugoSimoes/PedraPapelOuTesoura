package com.exemplo.pedrapapeloutesoura;

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

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView resultadoImagem = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[ numero ];

        switch (escolhaApp) {
            case "Pedra" :
                resultadoImagem.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                resultadoImagem.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                resultadoImagem.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                        (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                            (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ) {
            textoResultado.setText("Você perdeu ;(");
        } else if(
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                        (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                        (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")
        ) {
            textoResultado.setText("Você ganhou :D");
        } else {
            textoResultado.setText("Empate");
        }
        System.out.println("Item clicado: " + escolhaApp);

    }
}