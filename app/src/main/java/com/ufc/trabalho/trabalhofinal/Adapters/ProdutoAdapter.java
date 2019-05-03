package com.ufc.trabalho.trabalhofinal.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ufc.trabalho.trabalhofinal.Domain.Produto;
import com.ufc.trabalho.trabalhofinal.R;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    List<Produto> produtos;
    private ProdutoAdapter.OnProdutoListener mOnProdutoListener;

    public ProdutoAdapter(List<Produto> produtos, ProdutoAdapter.OnProdutoListener onProdutoListener) {
        this.produtos = produtos;
        this.mOnProdutoListener = onProdutoListener;
    }

    public static class ProdutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView nome, preco;
        ImageView imagemID;
        ProdutoAdapter.OnProdutoListener onProdutoListener;

        ProdutoViewHolder(View itemView, ProdutoAdapter.OnProdutoListener onProdutoListener) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv_produto);
            nome = itemView.findViewById(R.id.produto_nome);
            imagemID = itemView.findViewById(R.id.produto_imagem);
            preco = itemView.findViewById(R.id.produto_preco);
            this.onProdutoListener = onProdutoListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onProdutoListener.onProdutoClick(getAdapterPosition());
        }
    }

    public interface OnProdutoListener {
        void onProdutoClick(int position);
    }

    @Override
    public ProdutoAdapter.ProdutoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.produtos, viewGroup, false);
        ProdutoAdapter.ProdutoViewHolder pvh = new ProdutoAdapter.ProdutoViewHolder(v, mOnProdutoListener);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProdutoAdapter.ProdutoViewHolder produtoViewHolder, int i) {
        produtoViewHolder.nome.setText(produtos.get(i).getNome());
        produtoViewHolder.imagemID.setImageResource(produtos.get(i).getImageId());
        produtoViewHolder.preco.setText(produtos.get(i).getPreco().toString());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }
}
