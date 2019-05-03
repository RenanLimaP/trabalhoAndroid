package com.ufc.trabalho.trabalhofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ufc.trabalho.trabalhofinal.Adapters.CategoriaAdapter;
import com.ufc.trabalho.trabalhofinal.Domain.Categoria;
import com.ufc.trabalho.trabalhofinal.Domain.Produto;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HomeActiviry extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CategoriaAdapter.OnCategoriaListener {

    private static final String TAG = "HomeActivity";
    public static final String EXTRA_MESSAGE = "com.ufc.trabalho.trabalhofinal.MESSAGE";


    RecyclerView recyclerView;
    ArrayList<Categoria> categorias = new ArrayList<>();
    CategoriaAdapter categoriaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activiry);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rv);
        initializeData();
        initRecylerView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initializeData() {
        ArrayList<Produto> cervejas = new ArrayList<>();
        ArrayList<Produto> vinhos = new ArrayList<>();
        ArrayList<Produto> destilados = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cervejas.add(new Produto(i, "Skol", R.drawable.skol, new BigDecimal("3.5"+i)));
        }
        for (int i = 0; i < 3; i++) {
            vinhos.add(new Produto(i, "Pérgola", R.drawable.pergola, new BigDecimal("25.5"+i)));
        }
        for (int i = 0; i < 3; i++) {
            destilados.add(new Produto(i, "Smirnoff", R.drawable.smirnoff, new BigDecimal("40.3"+i)));
        }

        categorias.add(new Categoria("Cervejas", R.drawable.cerva, cervejas));
        categorias.add(new Categoria("Vinhos", R.drawable.vinho, vinhos));
        categorias.add(new Categoria("Destilados", R.drawable.destilados, destilados));

        for (int i = 0; i < 3; i++) {
            categorias.add(new Categoria(i, "Vinhos", R.drawable.vinho, vinhos));
        }
        for (int i = 0; i < 3; i++) {
            categorias.add(new Categoria(i, "Destilados", R.drawable.destilados, destilados));
        }
        for (int i = 0; i < 3; i++) {
            categorias.add(new Categoria(i, "Cerveja", R.drawable.cerva, cervejas));
        }
    }

    public void initRecylerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoriaAdapter = new CategoriaAdapter(categorias, this);
        recyclerView.setAdapter(categoriaAdapter);
    }

    @Override
    public void onCategoriaClick(int position) {
        Intent intent = new Intent(this, ProdutosActivity.class);
        intent.putExtra(EXTRA_MESSAGE, categorias.get(position).getProdutos());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_activiry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_carrinho) {
            Intent intent = new Intent(this, HomeActiviry.class);
            startActivity(intent);
        } else if (id == R.id.nav_categorias) {
            Intent intent = new Intent(this, HomeActiviry.class);
            startActivity(intent);
        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
