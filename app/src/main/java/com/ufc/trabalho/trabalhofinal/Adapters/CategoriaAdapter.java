package com.ufc.trabalho.trabalhofinal.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ufc.trabalho.trabalhofinal.Domain.Categoria;
import com.ufc.trabalho.trabalhofinal.R;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

    private static final String TAG = "CategoriaAdapter";

    List<Categoria> categorias;
    private OnCategoriaListener mOnCategoriaListener;

    public CategoriaAdapter(List<Categoria> categorias, OnCategoriaListener onCategoriaListener) {
        this.categorias = categorias;
        this.mOnCategoriaListener = onCategoriaListener;
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView nome;
        ImageView imagemID;
        OnCategoriaListener onCategoriaListener;

        CategoriaViewHolder(View itemView, OnCategoriaListener onCategoriaListener) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            nome = itemView.findViewById(R.id.categoria_nome);
            imagemID = itemView.findViewById(R.id.categoria_imagem);
            this.onCategoriaListener = onCategoriaListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCategoriaListener.onCategoriaClick(getAdapterPosition());
        }
    }

    public interface OnCategoriaListener {
        void onCategoriaClick(int position);
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        CategoriaViewHolder cvh = new CategoriaViewHolder(v, mOnCategoriaListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CategoriaViewHolder categoriaViewHolder, int i) {
        categoriaViewHolder.nome.setText(categorias.get(i).getNome());
        categoriaViewHolder.imagemID.setImageResource(categorias.get(i).getImagemId());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

}