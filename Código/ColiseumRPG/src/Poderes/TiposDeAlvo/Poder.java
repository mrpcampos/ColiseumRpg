/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poderes.TiposDeAlvo;

import java.util.function.Consumer;

/**
 *
 * @author Matheus
 */
public class Poder {
    protected String nome;
    protected String descricao;

    public Poder(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
