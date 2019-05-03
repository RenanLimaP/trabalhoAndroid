package com.ufc.trabalho.trabalhofinal.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Categoria implements Parcelable {

    Integer id;
    String nome;
    Integer imagemId;
    ArrayList<Produto> produtos = new ArrayList<>();

    public Categoria(){

    }

    public Categoria(String nome, Integer imagemId, ArrayList<Produto> produtos) {
        this.nome = nome;
        this.imagemId = imagemId;
        this.produtos = produtos;
    }

    public Categoria(Integer id, String nome, Integer imagemId, ArrayList<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.imagemId = imagemId;
        this.produtos = produtos;
    }

    protected Categoria(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        imagemId = in.readInt();
    }

    public static final Creator<Categoria> CREATOR = new Creator<Categoria>() {
        @Override
        public Categoria createFromParcel(Parcel in) {
            return new Categoria(in);
        }

        @Override
        public Categoria[] newArray(int size) {
            return new Categoria[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getImagemId() {
        return imagemId;
    }

    public void setImagemId(Integer imagemId) {
        this.imagemId = imagemId;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeInt(imagemId);
    }
}
