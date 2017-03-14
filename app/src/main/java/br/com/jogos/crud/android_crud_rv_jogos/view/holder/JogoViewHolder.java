package br.com.jogos.crud.android_crud_rv_jogos.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.jogos.crud.android_crud_rv_jogos.R;

/**
 * Created by Mescla on 14/03/2017.
 */

public class JogoViewHolder extends RecyclerView.ViewHolder {

    public final TextView nome;
    public final TextView fabricante;

    public JogoViewHolder(View view) {
        super(view);
        nome = (TextView) view.findViewById(R.id.tvNome);
        fabricante = (TextView) view.findViewById(R.id.tvFabricante);
        // restante das buscas
    }
}
