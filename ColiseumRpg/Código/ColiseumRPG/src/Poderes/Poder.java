/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poderes;

import Poderes.TipoDePoderes.Custo;

/**
 *
 * @author Matheus
 */
public class Poder {

    protected String nome;
    protected String descricao;
    protected Custo[] custos;

    public Poder(String nome, String descricao, Custo[] custo) {
        this.nome = nome;
        this.descricao = descricao;
        this.custos = custo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Custo[] getCustos() {
        return custos;
    }

}
