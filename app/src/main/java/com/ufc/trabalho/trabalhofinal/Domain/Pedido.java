package com.ufc.trabalho.trabalhofinal.Domain;

import java.util.HashSet;
import java.util.Set;

public class Pedido {

    private Integer id;
    private Cliente cliente;
    private Set<ItemPedido> itens = new HashSet<>();
}
