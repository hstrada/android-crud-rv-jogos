package br.com.jogos.crud.android_crud_rv_jogos;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.jogos.crud.android_crud_rv_jogos.dao.JogoDAO;
import br.com.jogos.crud.android_crud_rv_jogos.model.Jogo;

public class JogoActivity extends AppCompatActivity {

    public final static int CODE_JOGO = 1002;
    private TextInputLayout tilNome;
    private TextInputLayout tilFabricante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        tilNome = (TextInputLayout) findViewById(R.id.tilNome);
        tilFabricante = (TextInputLayout) findViewById(R.id.tilFabricante);

    }

    public void cadastrar(View v) {
        JogoDAO jogoDAO = new JogoDAO(this);
        Jogo jogo = new Jogo();
        jogo.setNome(tilNome.getEditText().getText().toString());
        jogo.setFabricante(tilFabricante.getEditText().getText().toString());
        jogoDAO.add(jogo);
        retornaParaTelaAnterior();
    }

    //retorna para tela de lista de torcedores
    public void retornaParaTelaAnterior() {
        Intent intentMessage = new Intent();
        setResult(CODE_JOGO, intentMessage);
        finish();
    }
}
