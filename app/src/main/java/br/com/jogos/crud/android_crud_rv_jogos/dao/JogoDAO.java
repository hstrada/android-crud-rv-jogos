package br.com.jogos.crud.android_crud_rv_jogos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.com.jogos.crud.android_crud_rv_jogos.model.Jogo;

/**
 * Created by Mescla on 14/03/2017.
 */

public class JogoDAO {

    private SQLiteDatabase db;
    private DBOpenHelper dbo;

    public JogoDAO(Context context) {
        dbo = new DBOpenHelper(context);
    }

    private static final String TABELA_JOGO = "jogo";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_FABRICANTE = "fabricante";

    //private static final String[] COLUMNS = {COLUNA_ID, COLUNA_NOME,COLUNA_CONSOLE_ID};
    public String add(Jogo jogo) {

        long resultado;
        SQLiteDatabase db = dbo.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, jogo.getNome());
        values.put(COLUNA_FABRICANTE, jogo.getFabricante());
        resultado = db.insert(TABELA_JOGO,
                null,
                values);
        db.close();
        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }

    public String update(Jogo jogo, Long id) {

        long resultado;
        SQLiteDatabase db = dbo.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, jogo.getNome());
        values.put(COLUNA_FABRICANTE, jogo.getFabricante());
        resultado = db.update(JogoDAO.TABELA_JOGO, values, JogoDAO.COLUNA_ID + "=" + id, null);

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }


    public List<Jogo> getAll() {
        List<Jogo> jogos = new LinkedList<>();
        String rawQuery = "SELECT id, nome, fabricante FROM " +
                JogoDAO.TABELA_JOGO;
        SQLiteDatabase db = dbo.getReadableDatabase();
        Cursor cursor = db.rawQuery(rawQuery, null);
        Jogo jogo = null;
        if (cursor.moveToFirst()) {
            do {
                jogo = new Jogo();
                jogo.setId(cursor.getLong(0));
                jogo.setNome(cursor.getString(1));
                jogo.setFabricante(cursor.getString(2));
                jogos.add(jogo);
            } while (cursor.moveToNext());
        }
        return jogos;
    }

    public Jogo getJogoById(Long id) {
        SQLiteDatabase db = dbo.getWritableDatabase();
        String query = "SELECT id, nome, fabricante FROM " + JogoDAO.TABELA_JOGO + " WHERE id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
        cursor.moveToFirst();
        Jogo jogo = new Jogo();
        jogo.setId(cursor.getLong(0));
        jogo.setNome(cursor.getString(1));
        jogo.setFabricante(cursor.getString(2));
        db.close();
        return jogo;
    }

    public void deletaJogo(Long id) {
        String where = COLUNA_ID + "=" + id;
        SQLiteDatabase db = dbo.getWritableDatabase();
        db.delete(JogoDAO.TABELA_JOGO, where, null);

    }

}
