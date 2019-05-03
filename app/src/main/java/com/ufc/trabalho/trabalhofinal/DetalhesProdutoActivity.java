package com.ufc.trabalho.trabalhofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ufc.trabalho.trabalhofinal.Domain.Produto;

public class DetalhesProdutoActivity extends AppCompatActivity {

    private TextView counterTxt, name, preco;
    private ImageButton plusBtn;
    private ImageButton minusBtn;
    private ImageView produtoImage;
    private int counter;
    Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        plusBtn = (ImageButton) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);
        minusBtn = (ImageButton) findViewById(R.id.miniBtn);
        minusBtn.setOnClickListener(clickListener);
        counterTxt = (TextView) findViewById(R.id.counterTxt);
        name = findViewById(R.id.name);
        produtoImage = findViewById(R.id.imageViewProduto);
        preco = findViewById(R.id.preco);
        initCounter();
        getList();
    }

    private void getList() {
        produto = new Produto();
        Intent i = getIntent();
        produto = (Produto) i.getSerializableExtra("prods");
        name.setText(produto.getNome());
        produtoImage.setImageResource(produto.getImageId());
        preco.setText(produto.getPreco().toString());
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.miniBtn :
                    minusCounter();
                    break;
                case R.id.plusBtn :
                    plusCounter();
                    break;
            }
        }
    };

    private void initCounter(){
        counter = 0;
        counterTxt.setText(counter + "");
    }

    private void plusCounter(){
        counter++;
        counterTxt.setText(counter + "");

    }

    private void minusCounter(){
        if(counter > 0){
            counter--;
            counterTxt.setText(counter + "");
        }

    }
}
