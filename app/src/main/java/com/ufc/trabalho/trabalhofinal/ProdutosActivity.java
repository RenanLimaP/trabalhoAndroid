package com.ufc.trabalho.trabalhofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ufc.trabalho.trabalhofinal.Adapters.CategoriaAdapter;
import com.ufc.trabalho.trabalhofinal.Adapters.ProdutoAdapter;
import com.ufc.trabalho.trabalhofinal.Domain.Categoria;
import com.ufc.trabalho.trabalhofinal.Domain.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutosActivity extends AppCompatActivity implements ProdutoAdapter.OnProdutoListener{

    private Categoria categoriaInitial;
    private int mMode;
    private Categoria categorialFinal;

    RecyclerView recyclerView;
    List<Produto> produtos;
    ProdutoAdapter produtoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rv_produtos);
        getList();
        initRecylerView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getList() {
        produtos = new ArrayList<>();
        Intent i = getIntent();
        produtos = (ArrayList<Produto>) i.getSerializableExtra(HomeActiviry.EXTRA_MESSAGE);
    }

    public void initRecylerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        produtoAdapter = new ProdutoAdapter(produtos, this);
        recyclerView.setAdapter(produtoAdapter);
    }

    private boolean getIncomingIntent() {
        if (getIntent().hasExtra("selected_categoria")) {
            categoriaInitial = getIntent().getParcelableExtra("selected_categoria");

            categorialFinal = new Categoria();
            categorialFinal.setId(categoriaInitial.getId());
            categorialFinal.setNome(categoriaInitial.getNome());
            categorialFinal.setImagemId(categoriaInitial.getImagemId());
        }
        return true;
    }

    @Override
    public void onProdutoClick(int position) {
        Intent intent = new Intent(this, DetalhesProdutoActivity.class);
        intent.putExtra("prods", produtos.get(position));
        startActivity(intent);
    }
}
