package br.com.jogos.crud.android_crud_rv_jogos;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.jogos.crud.android_crud_rv_jogos.dao.JogoDAO;
import br.com.jogos.crud.android_crud_rv_jogos.model.Jogo;

public class JogoActivity extends AppCompatActivity {

    public final static int CODE_JOGO = 1002;
    private TextInputLayout tilNome;
    private TextInputLayout tilFabricante;
    private EditText etNome;
    private EditText etFabricante;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        tilNome = (TextInputLayout) findViewById(R.id.tilNome);
        tilFabricante = (TextInputLayout) findViewById(R.id.tilFabricante);

        etNome = (EditText) findViewById(R.id.etNome);
        etFabricante = (EditText) findViewById(R.id.etFabricante);

        carregarJogo();

    }

    public void cadastrar(View v) {
        final Bundle extras = getIntent().getExtras();
        Long jogoId = (extras != null) ? extras.getLong("jogoId") : null;
        if (jogoId == null) {
            JogoDAO jogoDAO = new JogoDAO(this);
            Jogo jogo = new Jogo();
            jogo.setNome(tilNome.getEditText().getText().toString());
            jogo.setFabricante(tilFabricante.getEditText().getText().toString());
            jogoDAO.add(jogo);
        } else {
            Jogo jogo = new Jogo();
            JogoDAO jogoDAO = new JogoDAO(this);
            jogo.setNome(tilNome.getEditText().getText().toString());
            jogo.setFabricante(tilFabricante.getEditText().getText().toString());
            jogoDAO.update(jogo, jogoId);
        }
        retornaParaTelaAnterior();
    }

    //retorna para tela de lista de torcedores
    public void retornaParaTelaAnterior() {
        Intent intentMessage = new Intent();
        setResult(CODE_JOGO, intentMessage);
        finish();
    }

    public void carregarJogo() {
        final Bundle extras = getIntent().getExtras();
        Long jogoId = (extras != null) ? extras.getLong("jogoId") : null;

        if (jogoId == null) {
            Jogo jogo = new Jogo();
        } else {
            Jogo jogo = new Jogo();
            JogoDAO jogoDAO = new JogoDAO(this);
            jogo = jogoDAO.getJogoById(jogoId);
            etNome.setText(jogo.getNome().toString());
            etFabricante.setText(jogo.getFabricante().toString());

        }
    }
}
