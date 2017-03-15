package br.com.jogos.crud.android_crud_rv_jogos.view.holder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.com.jogos.crud.android_crud_rv_jogos.JogoActivity;
import br.com.jogos.crud.android_crud_rv_jogos.R;
import br.com.jogos.crud.android_crud_rv_jogos.dao.JogoDAO;
import br.com.jogos.crud.android_crud_rv_jogos.model.Jogo;
import br.com.jogos.crud.android_crud_rv_jogos.view.adapter.JogoAdapter;

/**
 * Created by Mescla on 14/03/2017.
 */

public class JogoViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

    public final TextView nome;
    public final TextView fabricante;
    private Long jogoId;
    public final JogoAdapter adapter;


    public JogoViewHolder(final View view, final JogoAdapter adapter) {
        super(view);
        this.adapter = adapter;

        view.setOnLongClickListener(this);

        nome = (TextView) view.findViewById(R.id.tvNome);
        fabricante = (TextView) view.findViewById(R.id.tvFabricante);
    }

    public void preencher(Jogo jogo) {
        jogoId = jogo.getId();
        nome.setText(jogo.getNome());
        fabricante.setText(jogo.getFabricante());
    }

    @Override
    public boolean onLongClick(final View v) {
        PopupMenu popup = new PopupMenu(v.getContext(), v);
        popup.getMenuInflater().inflate(R.menu.jogo_options, popup.getMenu());

        final Activity context = (Activity)v.getContext();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menuEditar:

                        final Intent intent = new Intent(context, JogoActivity.class);
                        intent.putExtra("jogoId", jogoId);
                        context.startActivityForResult(intent, JogoActivity.CODE_JOGO);

                        break;

                    case R.id.menuDeletar:
                        JogoDAO jogoDAO = new JogoDAO(context);
                        jogoDAO.deletaJogo(jogoId);
                        deletarJogo();
                        break;

                }

                return true;
            }
        });

        popup.show();
        return false;
    }


    public void deletarJogo(){
        adapter.remove(getAdapterPosition());
    }

}
