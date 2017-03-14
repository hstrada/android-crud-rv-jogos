package br.com.jogos.crud.android_crud_rv_jogos.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.jogos.crud.android_crud_rv_jogos.R;
import br.com.jogos.crud.android_crud_rv_jogos.model.Jogo;
import br.com.jogos.crud.android_crud_rv_jogos.view.holder.JogoViewHolder;

/**
 * Created by Mescla on 14/03/2017.
 */

public class JogoAdapter extends RecyclerView.Adapter {

    private List<Jogo> jogos;
    private Context context;

    public JogoAdapter(List<Jogo> jogos, Context context) {
        this.jogos = jogos;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.jogo_item_lista, parent, false);
        JogoViewHolder holder = new JogoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        JogoViewHolder viewHolder = (JogoViewHolder) holder;

        Jogo jogo  = jogos.get(position);

        ((JogoViewHolder) holder).nome.setText(jogo.getNome());
        ((JogoViewHolder) holder).fabricante.setText(jogo.getFabricante());

    }

    @Override
    public int getItemCount() {
        return jogos.size();
    }
}
